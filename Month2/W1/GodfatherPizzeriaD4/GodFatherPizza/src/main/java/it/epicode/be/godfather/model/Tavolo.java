package it.epicode.be.godfather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Tavolo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tavolo_seq")
    @SequenceGenerator(name = "tavolo_seq", sequenceName = "tavolo_seq")
    private Long id;
	
	private Integer numero;
	private Integer numeroMassimoCoperti;
	private Boolean occupato = false;

	public Tavolo(Integer numero, Integer numeroMassimoCoperti, Boolean occupato) {
		this.numero = numero;
		this.numeroMassimoCoperti = numeroMassimoCoperti;
		this.occupato = occupato;
	}
	
	

}
