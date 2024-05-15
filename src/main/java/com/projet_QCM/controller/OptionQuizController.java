package com.projet_QCM.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
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
	
	
	
	@GetMapping("/list")
	public String option(Model model) {
		model.addAttribute("options",optionQuizServiceImpl.getAll());
		return "optionQuiz/list";
	}

	
	@PostMapping
	public String inser(@Valid OptionQuiz option, BindingResult result, Model model, @RequestParam("nbreOpt") int nbreOpt, HttpSession session ) {
		
		Question question=questionServiceImpl.getById(option.getQuestion().getId_question());
		
		if (result.hasErrors()) {
			
			return "optionQuiz/index";
		}
		
		
		Long idQ=question.getId_question();
		
		System.out.println("id question "+idQ);
		System.out.println("Longueur tab option quiz "+optionQuizServiceImpl.nbreOption(idQ));
				
		optionQuizServiceImpl.create(option);
		
		if(optionQuizServiceImpl.nbreOption(idQ)!=nbreOpt) {
			for(OptionQuiz t:optionQuizServiceImpl.getAll()) {
				
				System.out.println("Les données "+t);
				
				session.setAttribute("questionObject", question);
				model.addAttribute("option", new OptionQuiz());	
				
				return "optionQuiz/index";
			}
			
		}
				
		return "redirect:/";
	}

	@GetMapping("/add")
	public String addQuiz(Model model) {
		model.addAttribute("option", new OptionQuiz());
		model.addAttribute("questions",questionServiceImpl.getAll() );
		
		return "optionQuiz/index";
	}

}
