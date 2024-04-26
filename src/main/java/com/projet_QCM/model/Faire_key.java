package com.projet_QCM.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Faire_key {

    private Object idUser;
    private  Object idQuiz;
}
