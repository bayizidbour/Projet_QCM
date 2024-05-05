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

    @GetMapping("/everyOne")
    public String everyOne() {
        return "utilisateur/everyOne";
    }
    
    @GetMapping("/user")
    public String user() {
        return "utilisateur/user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "utilisateur/admin";
    }
    @GetMapping("/question/add")
    public String addQuestion( Model model) {
    	model.addAttribute("question", new Question());
    	model.addAttribute("type", TypeQuestion.class);
    	return "question/index";
    }

    @GetMapping("/logon")
    public String logon(Model model) {
    	model.addAttribute("user", new User());
        return "utilisateur/logon";
    }
    
    @PostMapping("/logon")
    public String add(@ModelAttribute User user) {
    	user.setMdp(mdpEncoder().encode(user.getMdp()));
    	System.out.println(user);
    	userRepository.save(user);
        return "redirect:/";
    }
    
    BCryptPasswordEncoder mdpEncoder() {
    	return new BCryptPasswordEncoder();
    }


}
