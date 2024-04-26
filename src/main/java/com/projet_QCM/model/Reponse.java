package com.projet_QCM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Reponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_reponse;
	
	@ManyToOne
	@JoinColumn(name = "id_quiz")
	private Object quiz;
	
	@ManyToOne
	@JoinColumn(name = "id_option")
	private Object opt_Quiz;
}
