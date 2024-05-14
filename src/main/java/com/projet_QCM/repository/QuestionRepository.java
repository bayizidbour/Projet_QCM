package com.projet_QCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_QCM.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByLibelle(String libele);
}
