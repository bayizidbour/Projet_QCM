package com.projet_QCM.model;

import jakarta.persistence.*;
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
public class OptionQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_option;
    
    @NotNull
    @Column(length = 50)
    @Size(min = 2, max = 50)
    private String text_option;
    
    @NotNull
    private boolean est_correct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")    
    private Question question;
//
//    @OneToMany(mappedBy = "optQuiz")
//    private List<Reponse> reponseList;

	@Override
	public String toString() {
		return "OptionQuiz [id_option=" + id_option + ", text_option=" + text_option + ", est_correct=" + est_correct
				+ ", question=" + question  + "]";
	}
    
    
}
