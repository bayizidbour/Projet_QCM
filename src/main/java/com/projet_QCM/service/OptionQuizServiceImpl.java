package com.projet_QCM.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet_QCM.model.OptionQuiz;
import com.projet_QCM.model.Question;
import com.projet_QCM.repository.OptionQuizRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OptionQuizServiceImpl implements OjectService<OptionQuiz> {
	
	public final OptionQuizRepository optionQuizRepository;
	
	@Override
	public OptionQuiz create(OptionQuiz t) {
		return this.optionQuizRepository.save(t);
	}

	@Override
	public List<OptionQuiz> getAll() {
		return this.optionQuizRepository.findAll();
	}

	@Override
	public OptionQuiz getById(Long id) {
		
		return this.optionQuizRepository.findById(id).orElseThrow(()->new RuntimeException("Pas d'option quiz trouvée"));
	}

	@Override
	public void delete(Long id) {
		this.optionQuizRepository.deleteById(id);
		
	}

	@Override
	public OptionQuiz update(OptionQuiz opUp, Long id) {
		OptionQuiz opBD=getById(id);
			opBD.setEst_correct(opUp.isEst_correct());
			opBD.setText_option(opUp.getText_option());
			opBD.setQuestion(opUp.getQuestion());			
		return create(opBD);
	}
	
	public Long nbreOption(Long id) {
		return optionQuizRepository.nbreOption(id);
	}
	
	public List<OptionQuiz> getAllOptionByQuestion(Question question){
		return optionQuizRepository.findAllByQuestion(question);
	}

}
