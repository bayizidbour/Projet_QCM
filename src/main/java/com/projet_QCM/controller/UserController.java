package com.projet_QCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.projet_QCM.model.User;
import com.projet_QCM.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	
	SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "utilisateur/login";
	}

	@PostMapping("/login/failure")
	public String loginFailure() {
		return "redirect:/login?error";
	}

	@GetMapping("/logout")
	public String logout(
			Authentication authentication, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		this.logoutHandler.logout(request, response, authentication);
		
		return "redirect:/";
	}

	@GetMapping("/logon")
	public String logon(Model model) {
		model.addAttribute("user", new User());
		return "utilisateur/logon";
	}

	@PostMapping("/logon")
	public String add(@Valid User user, BindingResult result,RedirectAttributes ra, Model model ) {
		
		user.setMdp(mdpEncoder().encode(user.getMdp()));
		String email=user.getEmail();
		String login=user.getLogin();
		
		 if ( result.hasErrors() ) {
	            model.addAttribute("user", user);
	            return "utilisateur/logon";
	        }
	
		if(userRepository.findByLogin(login)!=null || userRepository.findByEmail(email)!=null) {
			 model.addAttribute("warning", "3");	
			 model.addAttribute("user",user);
			return "utilisateur/logon";
		}
	
		
		 userRepository.save(user);
		
		return "redirect:/";
	}

	BCryptPasswordEncoder mdpEncoder() {
		return new BCryptPasswordEncoder();
	}

}
