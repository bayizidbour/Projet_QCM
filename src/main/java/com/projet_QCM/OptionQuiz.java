package com.projet_QCM;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
