package com.mauriziovillanova.W6D5.progettosettimanalespringboot.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "utenti")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = " utente_ruoli",
			joinColumns = @JoinColumn(name = "utente_id"),
			inverseJoinColumns =  @JoinColumn(name ="ruolo_id")
)
 	private Set<Ruolo> ruoli = new HashSet<>();
 	@JsonIgnore
 	@OneToMany
 	private Set<Dispositivo> dispositivi;
 	}
