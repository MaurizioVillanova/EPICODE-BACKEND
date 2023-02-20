package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import enumm.tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="eventi")
@Getter
@Setter
@DiscriminatorColumn(name="evento_type",discriminatorType=DiscriminatorType.STRING)
@NoArgsConstructor

public class evento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private int numeroMassimoPartecipanti;
	@Enumerated(EnumType.STRING)
	private tipo tipoEvento;
	@OneToMany(mappedBy="evento",cascade= CascadeType.REMOVE)
	private Set<partecipazione> setPartecipazione;
	@ManyToOne
	private location location;
	
	
	public evento(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti,
			tipo tipoEvento) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.tipoEvento = tipoEvento;
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}
	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
	public tipo getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(tipo tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	
	
	
}
