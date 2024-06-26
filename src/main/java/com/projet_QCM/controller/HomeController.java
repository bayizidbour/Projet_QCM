package com.projet_QCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet_QCM.model.Question;
import com.projet_QCM.model.TypeQuestion;
import com.projet_QCM.model.User;
import com.projet_QCM.repository.UserRepository;

import jakarta.validation.Valid;


@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }



  


}
