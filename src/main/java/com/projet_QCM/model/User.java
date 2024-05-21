package com.projet_QCM.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(min = 2, max=20)
	@Column(length = 20, nullable = false)
	private String nom;
	
	@NotBlank
	@Size(min = 2, max=20)
	@Column(length = 20,nullable = false)
	private String prenom;
	
	@Size(min =10,max=50)
	@Column(length = 50, unique=true)
	private String email;
	
	@Column(length = 5)
	private String statut = "USER";
	
	@NotBlank
	@Size(min =6,max=8)
	@Column(length = 8, unique = true, nullable = false)
	private String login;

	@Column(length = 100, nullable = false)
	//@Pattern(regexp = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$/")
	private String mdp;

	@OneToMany(mappedBy = "user")
	private List<Moyenne> moyenneList;

	@OneToMany(mappedBy = "user")
	private List<Faire> faires;

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", email='" + email + '\''
				+ ", statut='" + statut + '\'' + ", login='" + login + '\'' + ", mdp='" + mdp + '\'' + '}';
	}
}
