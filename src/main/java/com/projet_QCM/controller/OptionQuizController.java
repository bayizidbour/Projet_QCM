package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.OptionQuiz;


@Controller
@RequestMapping("/optionQuiz")
public class OptionQuizController {
	
	
	 @GetMapping("/list")
	    public String option(){	      
	        return "optionQuiz/list";
	    }
	    @GetMapping("/add")
	    public String addQuiz(Model model){
	    	model.addAttribute("option", new OptionQuiz());
	        return "optionQuiz/index";
	    }
	
	

}
