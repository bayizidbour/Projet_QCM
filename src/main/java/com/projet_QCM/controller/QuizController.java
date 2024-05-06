package com.projet_QCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet_QCM.model.Quiz;
import com.projet_QCM.service.QuizServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    public final QuizServiceImpl quizService;

    @GetMapping("/list")
    public String getAllQuiz(Model model){
        model.addAttribute("quizs",quizService.getAll());
        return "quiz/list";
    }
    @GetMapping("/add")
    public String addQuiz(Model model){
    	model.addAttribute("quiz", new Quiz());
        return "quiz/index";
    }
    
    

    @PostMapping("/inserer")
    public String insererQuiz(@Valid Quiz quiz, BindingResult result, Model model){

        model.addAttribute("quiz", new Quiz());
        if ( result.hasErrors() ) {
            return "";
        }
        quizService.create(quiz);
        return "";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable long id){
        quizService.getById(id);
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        quizService.delete(id);
        return "";
    }

    @PutMapping("/update/{id}")
    public String update(Quiz quiz, @PathVariable long id){
        quizService.delete(id);
        return "";
    }

}
