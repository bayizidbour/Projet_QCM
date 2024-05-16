package com.projet_QCM.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projet_QCM.model.Quiz;
import com.projet_QCM.service.QuizServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class QuizController {

	public final QuizServiceImpl quizService;

	// Afficher la liste des quiz

	@GetMapping("/admin/quiz/list")
	public String getAllQuiz(Model model) {
		model.addAttribute("quizs", quizService.getAll());
		return "quiz/list";
	}

	// Ajouter un quiz

	@GetMapping("/admin/quiz/add")
	public String addQuiz(Model model) {
		model.addAttribute("quiz", new Quiz());
		model.addAttribute("date_now", LocalDate.now());
		
		return "quiz/index";
	}
	
	// Créer et ajouter un quiz dans la base de donnée
		@PostMapping("/admin/quiz/inserer")
		public String createQuiz(@Valid Quiz quiz, BindingResult result, RedirectAttributes ra) {
			
			if(result.hasErrors()) {
				return "quiz/index";
			}
			
			if(quiz.getId() != null) {
				System.out.println("update ok");
				quizService.update(quiz, quiz.getId());
				ra.addFlashAttribute("success", "Le quiz est modifié avec success");
			}else {
				System.out.println("update Non ok");
				quizService.create(quiz);
				ra.addFlashAttribute("success", "Le quiz est ajouté avec success");
			}
			return "redirect:/admin/quiz/list";
		}

//		// Créer et ajouter un quiz dans la base de donnée
//				@PostMapping("/admin/quiz/update")
//				public String updateQuiz(@Valid Quiz quiz, BindingResult result, RedirectAttributes ra) {
//					
//					if(result.hasErrors()) {
//						return "quiz/index";
//					}
//					
//					if(quiz.getId() != 0) {
//						quizService.update(quiz, quiz.getId());
//						ra.addFlashAttribute("success", "Le quiz est modifié avec success");
//					}
//					return "redirect:/admin/quiz/list";
//				}
	// Afficher les quiz à passer

	@GetMapping("/user/quiz/done")
	public String doneQuiz(Model model) {
		model.addAttribute("quizs", quizService.getAll());
		model.addAttribute("date_now", LocalDate.now());
		return "eleve/index";
	}

	

	// Soumettre quiz
	@GetMapping("/user/quiz/done/examen")
	public String examenQuiz(Model model) {
		
		return "eleve/examen";
	}

	// Confirmer soumission Quiz
	@GetMapping("/user/quiz/done/examen/confirm")
	public String confirmationQuiz(Model model) {
		return "eleve/confirm";
	}

	// Afficher note QUiz

	@GetMapping("/user/quiz")
	public String insererQuiz(Model model) {
		return "eleve/note";
	}

	// Consulter Moyenne Quiz

	@GetMapping("/user/quiz/moyenne")
	public String moyenneQUiz(Model model) {
		return "eleve/moyenne";
	}

	// --------------------------------------------
	@GetMapping("/{id}")
	public String getById(@PathVariable Long id) {
		quizService.getById(id);
		return "";
	}

	@GetMapping("/quiz/delete/admin/{id}")
	public String delete(@PathVariable Long id) {
		quizService.delete(id);
		return "redirect:/admin/quiz/list";
	}

	@GetMapping("/quiz/update/admin/{id}")
	public String update(Model model, @PathVariable Long id, RedirectAttributes ra) {
		Optional<Quiz> qz = quizService.getQuizById(id);
		
		if(qz.isPresent()) {
			model.addAttribute("quiz", qz.get());
			model.addAttribute("date_now", LocalDate.now());
			return "quiz/index";
		}
			
		return "redirect:/admin/quiz/list";
	
	}

}
