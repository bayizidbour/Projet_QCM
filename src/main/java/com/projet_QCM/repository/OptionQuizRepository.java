package com.projet_QCM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
import com.projet_QCM.model.Quiz;

public interface OptionQuizRepository extends JpaRepository<OptionQuiz, Long> {

	List<OptionQuiz> findAllByQuestion(Question question);
	
	@Query(value="SELECT count(id_option) from option_quiz where option_quiz.question_id=:id", nativeQuery=true)
	Long nbreOption(@Param("id") Long id);
	
	
}
