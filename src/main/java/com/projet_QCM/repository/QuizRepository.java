package com.projet_QCM.repository;


import com.projet_QCM.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

	@Query(value = "UPDATE quiz SET nb_question=:nbr WHERE id=:id ", nativeQuery = true)
	Quiz updateQuiz(@Param("nbr") Long nbr, @Param("id") Long id);
	
	Quiz findByTitre(String titre);
}
