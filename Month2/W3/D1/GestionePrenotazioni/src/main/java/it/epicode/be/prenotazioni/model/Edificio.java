package it.epicode.be.prenotazioni.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import it.epicode.be.prenotazioni.security.encryption.StringAttributeConverter;
import lombok.Data;

@Data
@Entity
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	
	@Convert(converter = StringAttributeConverter.class)
	private String securityCode;
	
	@ManyToOne
	private Citta citta;
}
