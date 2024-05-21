package com.projet_QCM.controller;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Optional;

=======
import com.projet_QCM.model.Faire;
import com.projet_QCM.model.User;
import org.springframework.security.core.Authentication;
>>>>>>> ubuntu/sogore
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

import java.util.List;

@Controller
@AllArgsConstructor
public class QuizController {

	public final QuizServiceImpl quizService;

<<<<<<< HEAD
	// Afficher la liste des quiz
=======
    // Afficher la liste des quiz
    
    @GetMapping("/admin/quiz/list")
    public String getAllQuiz(Model model){
        model.addAttribute("quizs",quizService.getAll());
        return "quiz/list";
    }
    
    // Ajouter un quiz
   
    @GetMapping("/admin/quiz/add")
    public String addQuiz(Model model){
    	model.addAttribute("quiz", new Quiz());
        return "quiz/index";
    }
    
    //Afficher les quiz à passer
    
    @GetMapping("/user/quiz/done")
    public String doneQuiz(Model model){   	
        return "eleve/index";
    }
    
    // Soumettre quiz
    @GetMapping("/user/quiz/done/examen")
    public String examenQuiz(Model model){   	
        return "eleve/examen";
    }
    
    // Confirmer soumission Quiz
    @GetMapping("/user/quiz/done/examen/confirm")
    public String confirmationQuiz(Model model){   	
    	return "eleve/confirm";
    }
    
    // Afficher note QUiz
   
    @GetMapping("/user/quiz")
    public String insererQuiz(Model model){
        return "eleve/note";
    }
    
    //Consulter Moyenne Quiz
    
    @GetMapping("/user/quiz/moyenne")
    public String moyenneQUiz(Model model, Authentication auth){
        //Récupérer l'utilisateur connecté
        User user = this.quizService.findUserByLogin(auth.getName());
        //Récupérer les notes
        List<Faire> faire = user.getFaires();
        //calculler et afficher sa moyenne
        double moyenne =  this.quizService.calculMoyenneByIdUser(user.getId());
        model.addAttribute("moyenne",moyenne);
        model.addAttribute("faires",faire);
        return "eleve/moyenne";
    }
    
    
    
    // --------------------------------------------
    @GetMapping("/{id}")
    public String getById(@PathVariable long id){
        quizService.getById(id);
        return "";
    }
>>>>>>> ubuntu/sogore

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

		if (result.hasErrors()) {
			return "quiz/index";
		}
		System.out.println("dehors" + quiz.getId());
		if (quiz.getId() != null) {
			System.out.println("dedans" + quiz.getId());
			quizService.update(quiz, quiz.getId());
			ra.addFlashAttribute("success", "Le quiz est modifié avec success");
		} else {
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

		model.addAttribute("quiz", quizService.getById(id));
		model.addAttribute("date_now", LocalDate.now());
		return "quiz/index";

	}

}
