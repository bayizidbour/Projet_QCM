package com.projet_QCM.modele;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String titre;

    @Column
    private LocalDate duree;

    @Column
    private LocalDate date_creation= LocalDate.now();

    @Column
    private LocalDate date_debut;

    @Column
    private LocalDate date_expiration;

    @ManyToOne
    @JoinColumn(name = "object_id")
    private Object object;






}
