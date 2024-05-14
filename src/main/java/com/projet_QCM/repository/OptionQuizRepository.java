package com.projet_QCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet_QCM.model.OptionQuiz;

public interface OptionQuizRepository extends JpaRepository<OptionQuiz, Long> {

	@Query(value="SELECT count(id_option) from option_quiz where option_quiz.question_id=:id", nativeQuery=true)
	Long nbreOption(@Param("id") Long id);
	
}
