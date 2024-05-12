package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.Question;
import com.projet_QCM.model.TypeQuestion;
import com.projet_QCM.service.QuestionServiceImpl;
import com.projet_QCM.service.QuizServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/question")
@AllArgsConstructor
public class QuestionController {
	
	
	public final QuestionServiceImpl questionServiceImpl;
	public final QuizServiceImpl quizServiceImpl;
	
	
    @GetMapping("/add")
    public String addQuestion( Model model) {
    	model.addAttribute("question", new Question());
    	model.addAttribute("type", TypeQuestion.class);
    	model.addAttribute("");
    	model.addAttribute("quizs",quizServiceImpl.getAll() );
    	return "question/index";
    }
    @PostMapping
    public String inser(@Valid Question question, BindingResult result,Model model) {
    	 
    	if ( result.hasErrors() ) {
             return "question/index";
         }    	
    	questionServiceImpl.create(question);
    	return "redirect:/";
    }
    
    @GetMapping("/list")
    public String questionList() {
        return "question/list";
    }

}
