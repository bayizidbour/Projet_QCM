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
public class OptionQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_option;

    private String text_option;
    private boolean est_correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "optQuiz")
    private List<Reponse> reponseList;

	@Override
	public String toString() {
		return "OptionQuiz [id_option=" + id_option + ", text_option=" + text_option + ", est_correct=" + est_correct
				+ ", question=" + question + ", reponseList=" + reponseList + "]";
	}
    
    
}
