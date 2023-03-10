package com.mauriziovillanova.progettosettimanale.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Table(name = "prenotazioni")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Prenotazione {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;

	    private LocalDate data;

	    @OneToOne
	    private Postazione postazione;
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
}
