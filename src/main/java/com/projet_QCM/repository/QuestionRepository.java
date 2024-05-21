package com.projet_QCM.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet_QCM.model.Question;
import com.projet_QCM.model.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByLibelle(String libele);
	
	List<Question> findAllByQuiz(Quiz quiz);
	
	@Query(value = "SELECT * FROM question WHERE libelle=:libelle AND quiz_id=:idQ LIMIT 1", nativeQuery = true)
	Question findBylibelleAndQuiz(@Param("libelle") String libelle, @Param("idQ") Long idQ);

	@Query(value = "SELECT * FROM question WHERE libelle=:libelle  LIMIT 1", nativeQuery = true)
	Question getBylibelle(@Param("libelle") String libelle);

	@Query(value = "SELECT COUNT(id_question)+1 FROM question WHERE quiz_id=:id", nativeQuery = true)
	Long total(@Param("id") Long id);
	
	
}
