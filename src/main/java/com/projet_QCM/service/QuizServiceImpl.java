package com.projet_QCM.service;

import com.projet_QCM.model.Quiz;
import com.projet_QCM.model.User;
import com.projet_QCM.repository.FaireRepository;
import com.projet_QCM.repository.QuizRepository;
import com.projet_QCM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Quiz getById(Long id) {
        return this.quizRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de quiz trouvée"));
    }

    @Override
    public void delete(Long id) {
        this.quizRepository.deleteById(id);

    }

    @Override
    public Quiz update(Quiz quizUp,Long id) {
        Quiz quizBD=getById(id);
            quizBD.setTitre(quizUp.getTitre());
            quizBD.setDuree(quizUp.getDuree());
           // quizBD.setUser(quizUp.getUser());
            quizBD.setDate_debut(quizUp.getDate_debut());
            quizBD.setDate_creation(quizUp.getDate_creation());
            quizBD.setDate_expiration(quizUp.getDate_expiration());
        return create(quizBD);
    }
    
   
    public Quiz updateQ(Quiz quizUp,Long id) {
        Quiz quizBD=getById(id);
        
            quizBD.setId(quizUp.getId());
            quizBD.setTitre(quizUp.getTitre());
            quizBD.setDuree(quizUp.getDuree());
           // quizBD.setUser(quizUp.getUser());
            quizBD.setDate_debut(quizUp.getDate_debut());
            quizBD.setDate_creation(quizUp.getDate_creation());
            quizBD.setDate_expiration(quizUp.getDate_expiration());
            quizBD.setNbQuestion(quizUp.getNbQuestion());
        return create(quizBD);
    }


    public User findUserByLogin(String login){
        return this.userRepository.findByLogin(login);
    }

    public double calculMoyenneByIdUser(int id){
        return this.faireRepository.calculMoyenneByIdUser(id);
    }
    
    public Quiz updateQuiz(Long nbr, Long id) {
    return this.quizRepository.updateQuiz(nbr, id);
    }

}