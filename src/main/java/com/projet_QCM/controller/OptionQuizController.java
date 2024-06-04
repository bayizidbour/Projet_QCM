package com.projet_QCM.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
import com.projet_QCM.model.Quiz;
import com.projet_QCM.service.OptionQuizServiceImpl;
import com.projet_QCM.service.QuestionServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/optionQuiz")
@AllArgsConstructor
public class OptionQuizController {

	
	public final OptionQuizServiceImpl optionQuizServiceImpl;
	public final QuestionServiceImpl questionServiceImpl;
	
	
	
	@GetMapping("/list/{id}")
	public String option(@PathVariable Long id, Model model) {
		
		Question question = questionServiceImpl.getById(id);
		
		model.addAttribute("options",optionQuizServiceImpl.getAllOptionByQuestion(question));
		return "optionQuiz/list";
	}
	
	
	
	@GetMapping("/list")
	public String option( Model model) {
		
		model.addAttribute("options",optionQuizServiceImpl.getAll());
		return "optionQuiz/listOption";
	}

	
	@PostMapping
	public String inser( Model model,
			@RequestParam("nbreOpt") int nbreOpt,
			@RequestParam("id_question") int id_question,
			@RequestParam("reponse") String [] reponse,
			@RequestParam("trueFalse") int [] trueFalse,
			HttpSession session ) {
		
		
		
//		if (result.hasErrors()) {
//			
//			return "optionQuiz/index";
//		}
		 
		
		for (int i = 0; i< reponse.length; i++) {
			boolean bool = false;
			
			for(int t : trueFalse) {
				if(t == (i+1)) {
					bool = true;
					break;
				}
			}
			
			OptionQuiz optionQuiz = new OptionQuiz(null, reponse[i], bool, questionServiceImpl.getById((long) id_question));
			
			optionQuizServiceImpl.create(optionQuiz);
			
			//Recupérer Quiz dans question
			Question question = questionServiceImpl.getById((long) id_question);
			Quiz quiz = question.getQuiz();
			
			System.out.print(quiz);
			System.out.print(quiz.getQuestionList());
			
			for (Question q : quiz.getQuestionList() ) {
				System.out.println(q.getLibelle());
				for(OptionQuiz opt : q.getOptionQuizList()) {
					System.out.println(opt.getText_option());
				}
			}
			
			model.addAttribute("quiz", question.getQuiz());
			
			return "quiz/quiz";
			
		}
	
		
/*
 
		optionQuizServiceImpl.create(option);
		
		if(optionQuizServiceImpl.nbreOption(idQ)!=nbreOpt) {
			for(OptionQuiz t:optionQuizServiceImpl.getAll()) {
				
				System.out.println("Les données "+t);
				
				session.setAttribute("questionObject", question);
				model.addAttribute("option", new OptionQuiz());	
				
				return "optionQuiz/index";
			}
			
		}
		*/		
		return "redirect:/admin/quiz";
	}

	@GetMapping("/add")
	public String addQuiz(Model model) {
		model.addAttribute("option", new OptionQuiz());
		model.addAttribute("questions",questionServiceImpl.getAll() );
		
		return "optionQuiz/index";
	}

}
