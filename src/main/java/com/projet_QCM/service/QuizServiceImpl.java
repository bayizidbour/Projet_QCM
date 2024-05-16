package com.projet_QCM.service;

import com.projet_QCM.model.Quiz;
import com.projet_QCM.model.User;
import com.projet_QCM.repository.FaireRepository;
import com.projet_QCM.repository.QuizRepository;
import com.projet_QCM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizServiceImpl  implements OjectService<Quiz>{

    public final QuizRepository quizRepository;
    public final UserRepository userRepository;
    private final FaireRepository faireRepository;



    @Override
    public Quiz create(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return this.quizRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Quiz getById(Long id) {
        return this.quizRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de quiz trouvée"));
=======
    public Quiz  getById(Long id) {
        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de quiz trouvée"));
>>>>>>> bayizid
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
<<<<<<< HEAD
        Quiz quizBD=getById(id);
=======
    	
    	
       Quiz  quizBD=getById(id);
>>>>>>> bayizid
            quizBD.setTitre(quizUp.getTitre());
            quizBD.setDuree(quizUp.getDuree());
           // quizBD.setUser(quizUp.getUser());
            quizBD.setDate_debut(quizUp.getDate_debut());
            quizBD.setDate_creation(quizUp.getDate_creation());
            quizBD.setDate_expiration(quizUp.getDate_expiration());
            
          
        return create(quizBD);	
    	
    }


    public User findUserByLogin(String login){
        return this.userRepository.findByLogin(login);
    }

    public double calculMoyenneByIdUser(int id){
        return this.faireRepository.calculMoyenneByIdUser(id);
    }
}
