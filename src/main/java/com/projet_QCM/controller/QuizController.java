package com.projet_QCM.controller;

import com.projet_QCM.model.Faire;
import com.projet_QCM.model.User;
import org.springframework.security.core.Authentication;
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

import com.projet_QCM.model.Quiz;
import com.projet_QCM.service.QuizServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller
@AllArgsConstructor
public class QuizController {

    public final QuizServiceImpl quizService;

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
    	model.addAttribute("quizs", quizService.getAll());
        return "eleve/index";
    }
    
    // Soumettre quiz
    @GetMapping("/user/quiz/done/examen/{id}")
    public String examenQuiz(Model model,@PathVariable Long id){  
    	
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
    public String getById(@PathVariable Long id){
        quizService.getById(id);
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        quizService.delete(id);
        return "";
    }

    @PutMapping("/update/{id}")
    public String update(Quiz quiz, @PathVariable Long id){
        quizService.delete(id);
        return "";
    }

}
