package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
import com.projet_QCM.service.OptionQuizServiceImpl;
import com.projet_QCM.service.QuestionServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/optionQuiz")
@AllArgsConstructor
public class OptionQuizController {

	
	public final OptionQuizServiceImpl optionQuizServiceImpl;
	public final QuestionServiceImpl questionServiceImpl;
	
	
	@GetMapping("/list")
	public String option() {
		return "optionQuiz/list";
	}

	@PostMapping
	public String inser(@Valid OptionQuiz option, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "optionQuiz/index";
		}
		
		System.out.println(option);
		optionQuizServiceImpl.create(option);
		return "redirect:/";
	}

	@GetMapping("/add")
	public String addQuiz(Model model) {
		model.addAttribute("option", new OptionQuiz());
		model.addAttribute("questions",questionServiceImpl.getAll() );
		
		return "optionQuiz/index";
	}

}
