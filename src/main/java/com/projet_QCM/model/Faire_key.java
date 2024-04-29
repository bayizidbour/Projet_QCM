package com.projet_QCM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Faire_key {

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "quiz_id")
    private  Long quiz_id;
}