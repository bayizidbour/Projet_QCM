package com.projet_QCM.service;

import com.projet_QCM.model.Quiz;
import com.projet_QCM.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizServiceImpl  implements OjectService<Quiz>{

    public final QuizRepository quizRepository;



    @Override
    public Quiz create(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return this.quizRepository.findAll();
    }

    @Override
    public Quiz  getById(Long id) {
        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de quiz trouvée"));
    }

    @Override
    public void delete(Long id) {
        this.quizRepository.deleteById(id);

    }

    public Optional<Quiz> getQuizById(Long id){
    	return quizRepository.findById(id);
    }
   
    @Override
    public Quiz update(Quiz quizUp,Long id) {
    	
    	
       Quiz  quizBD=getById(id);
            quizBD.setTitre(quizUp.getTitre());
            quizBD.setDuree(quizUp.getDuree());
            quizBD.setUser(quizUp.getUser());
            quizBD.setDate_debut(quizUp.getDate_debut());
            quizBD.setDate_creation(quizUp.getDate_creation());
            quizBD.setDate_expiration(quizUp.getDate_expiration());
            
          
        return create(quizBD);	
    	
    }


}
