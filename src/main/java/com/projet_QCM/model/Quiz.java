package com.projet_QCM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
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
    @JoinColumn(name = "user_id")
    private Object user;






}
