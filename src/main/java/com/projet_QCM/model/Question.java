package com.projet_QCM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    
    @Column(nullable = false, length = 50)
    @Size(min = 2, max=50)
    private String libelle;

    @Column(nullable = false)
    private String typeQuestion;
    
    @Min(value = 2)
    @Column(nullable = false)
    private int nbreOption=2;
    
    @Min(value = 1)
    @Max(value = 20)
    @Column(nullable = false)
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
