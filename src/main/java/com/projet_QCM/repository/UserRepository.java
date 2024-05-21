package com.projet_QCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_QCM.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{	
	User findByLogin(String login);
	User findByEmail(String email);

}
