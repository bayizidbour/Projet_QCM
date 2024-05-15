package com.projet_QCM.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;
    
    @Column(unique =true)
    private String libelle;

    
    private String typeQuestion;
    
    private int nbreOption;

    private double point;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<OptionQuiz> optionQuizList;

	@Override
	public String toString() {
		return "Question = id_question=" + id_question + ", libelle=" + libelle + ", typeQuestion=" + typeQuestion;
	}
    
    

}
