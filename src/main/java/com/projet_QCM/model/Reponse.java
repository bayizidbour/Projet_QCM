package com.projet_QCM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_reponse;
	
	@ManyToOne
	@JoinColumn(name = "optQuiz_id")
	private OptionQuiz optQuiz;

	@Override
	public String toString() {
		return "Reponse{" +
				"id_reponse=" + id_reponse +
				", opt_Quiz=" + optQuiz +
				'}';
	}
}
