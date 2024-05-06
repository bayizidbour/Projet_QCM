package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.Question;
import com.projet_QCM.model.TypeQuestion;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
    @GetMapping("/add")
    public String addQuestion( Model model) {
    	model.addAttribute("question", new Question());
    	model.addAttribute("type", TypeQuestion.class);
    	return "question/index";
    }
    
    @GetMapping("/list")
    public String questionList() {
        return "question/list";
    }

}
