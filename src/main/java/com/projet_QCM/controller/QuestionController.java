package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
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
    	model.addAttribute("quizs",quizServiceImpl.getAll() );
    	return "question/index";
    }
    @PostMapping
    public String inser(@Valid Question question, BindingResult result,Model model, HttpSession session) {
    	 
    	if ( result.hasErrors() ) {
             return "question/index";
         } 
    	
    	questionServiceImpl.create(question);
    	
    	if(question!=null) {		
    		String libelle=question.getLibelle();
        	model.addAttribute("option", new OptionQuiz());
        	session.setAttribute("questionObject",questionServiceImpl.getByLibelle(libelle) );
    	}
	
    	return "redirect:/admin/question/list";
    }
    
    @GetMapping("/list")
    public String questionList(Model model) {
    	model.addAttribute("questions", questionServiceImpl.getAll());
        return "question/list";
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    	System.out.println(id);
    		questionServiceImpl.delete(id);
    	return "redirect: question/list";
    }
    

}
