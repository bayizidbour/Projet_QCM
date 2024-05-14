package com.projet_QCM.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet_QCM.model.Question;
import com.projet_QCM.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class QuestionServiceImpl implements  OjectService<Question> {

	public final QuestionRepository questionRepository;
	
	
	@Override
	public Question create(Question t) {		
		return this.questionRepository.save(t);
	}

	@Override
	public List<Question> getAll() {	
		return this.questionRepository.findAll();
	}

	@Override
	public Question getById(Long id) {	
		return this.questionRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de quiz trouvée"));
	}

	@Override
	public void delete(Long id) {
		this.questionRepository.deleteById(id);
		
	}
	@Override
	public Question update(Question qUp, Long id) {
		Question qBD=getById(id);
			qBD.setLibelle(qUp.getLibelle());
			qBD.setPoint(qUp.getPoint());
			
		return create(qBD);
	}
	
	public Question getByLibelle(String l) {
		return this.questionRepository.findByLibelle(l);
	}

}
