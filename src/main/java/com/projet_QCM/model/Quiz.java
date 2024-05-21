package com.projet_QCM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 25, unique=true)
    @Size(min = 2, max = 25)
    private String titre;

    private int duree;

    private Long nbQuestion;
    
    private LocalDate date_creation= LocalDate.now();
    
  
  
    private LocalDate date_debut;
    
 
    private LocalDate date_expiration;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "quiz")
    private List<Faire> faires;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questionList;





    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", duree=" + duree +
                ", date_creation=" + date_creation +
                ", date_debut=" + date_debut +
                ", date_expiration=" + date_expiration +
                ", user=" + user +
                ", questionList=" + questionList +
                ", nbQuestion=" + nbQuestion +
                '}';
    }
}
