package com.projet_QCM.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;

    private String libelle;

    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;

    private double point;

}
