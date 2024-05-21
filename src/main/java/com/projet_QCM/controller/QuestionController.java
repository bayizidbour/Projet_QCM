package com.projet_QCM.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
import com.projet_QCM.model.Quiz;
import com.projet_QCM.model.TypeQuestion;
import com.projet_QCM.service.QuestionServiceImpl;
import com.projet_QCM.service.QuizServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/question")
@AllArgsConstructor
public class QuestionController {

	public final QuestionServiceImpl questionServiceImpl;
	public final QuizServiceImpl quizServiceImpl;

	@GetMapping("/add/{id}")
	public String addQuestion(@PathVariable Long id, Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("type", TypeQuestion.class);
		model.addAttribute("quizID", id);
		model.addAttribute("quizs", quizServiceImpl.getAll());
		return "question/index";
	}

	@PostMapping
	public String inser(@Valid Question question, BindingResult result, Model model, HttpSession session) {
		String libelle = question.getLibelle();
		Long idQ = question.getQuiz().getId();

		if (result.hasErrors() || (questionServiceImpl.getByLibeAndQuiz(libelle, idQ) != null)) {
			model.addAttribute("question", new Question());
			model.addAttribute("type", TypeQuestion.class);
			model.addAttribute("warning", "true");
			model.addAttribute("quizID", idQ);
			model.addAttribute("quizs", quizServiceImpl.getAll());
			return "question/index";
		}
		
		Long total = questionServiceImpl.totalQuestion(idQ);
		Quiz quiz = quizServiceImpl.getById(idQ);
		quiz.setNbQuestion(total);
		
		questionServiceImpl.create(question);

		if (question != null) {

			model.addAttribute("option", new OptionQuiz());
			session.setAttribute("questionObject", questionServiceImpl.getByLibelle(libelle));
		}

		return "optionQuiz/index";
	}

	@GetMapping("/list")
	public String questionList(Model model) {
		model.addAttribute("questions", questionServiceImpl.getAll());
		return "question/list";
	}

	@GetMapping("/listQuestion/{id}")
	public String listQuestions(@PathVariable Long id, Model model) {
		Quiz quiz = quizServiceImpl.getById(id);

		model.addAttribute("questions", questionServiceImpl.getAllByQuiz(quiz));
		model.addAttribute("nomQuiz", quiz.getTitre());
		return "question/listQuestion";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		
		
		Question question = questionServiceImpl.getById(id);
		Long idQuiz = question.getQuiz().getId();
	
		Quiz quiz = quizServiceImpl.getById(idQuiz);
		questionServiceImpl.delete(id);
		Long total = questionServiceImpl.totalQuestion(idQuiz)-1;
		quiz.setNbQuestion(total);
		quizServiceImpl.updateQ(quiz, idQuiz);
		System.out.println(quiz);
		System.out.println(total);
		return "redirect:/admin/question/list";
	}
	
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable Long id, RedirectAttributes ra) {

		Question question = questionServiceImpl.getById(id);
	
		model.addAttribute("question", question);
		model.addAttribute("quizID", question.getQuiz().getId());
		
		return "quiz/index";

	}

}
