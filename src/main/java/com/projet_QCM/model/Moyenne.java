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
public class Moyenne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_moyenne;

    private double moyenne;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
