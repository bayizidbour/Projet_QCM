package com.projet_QCM.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class user {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    
	@Column( length = 20 )
    private String         nom;
    
    @Column( length = 20 )
    private String prenom;
    
    @Column( length = 20 )
    private String         email;
    
    @Column( length = 20 )
    private String         statut;
    
    @Column( length = 8 )
    private String         login;
    
    @Column( length = 20 )
    private String         mdp;
}
