package com.projet_QCM.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projet_QCM.enums.Statut;
import com.projet_QCM.repository.UserRepository;

@Service
public class ServiceUserDetails implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.projet_QCM.model.User user = userRepository.findByLogin(username);
		System.out.println("service " + user);
		
		User us = new User(user.getLogin(), user.getMdp(), grantedAuthorities(user.getStatut()));
		
		return us;
	}
	
	private ArrayList<GrantedAuthority> grantedAuthorities(Statut role){
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		
		return authorities;
	}

}
