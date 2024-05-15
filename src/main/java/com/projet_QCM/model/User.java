package com.projet_QCM.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.projet_QCM.enums.Statut;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    
	@Column( length = 20 )
    private String         nom;
    
    @Column( length = 20 )
    private String prenom;
    
    @Column( length = 20 )
    private String         email;
    
    @Enumerated(EnumType.STRING)
    @Column( length = 20 )

    //private String  statut="USER";
    private Statut statut;//ELEVE ?????
    
    @Column( length = 8, unique= true, nullable = false)
    private String         login;
    
    @Column( length = 100 )
    private String         mdp;

    @OneToMany(mappedBy = "user")
    private List<Moyenne> moyenneList;

    @OneToMany(mappedBy = "user")
    private List<Faire> faires;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", statut='" + statut + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
