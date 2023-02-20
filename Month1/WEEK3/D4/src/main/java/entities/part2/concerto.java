package entities.part2;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import entities.evento;
import enumm.genere;
import enumm.tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="concerto")

@NoArgsConstructor
@DiscriminatorValue("concertoo")
@Getter
@Setter
public class concerto extends evento{
private boolean inStreaming;
@Enumerated(EnumType.STRING)
private genere genere;
public concerto(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti,
		tipo tipoEvento,boolean inStreaming,genere genere) {
	super(titolo,dataEvento,descrizione,numeroMassimoPartecipanti,tipoEvento);
	this.inStreaming=inStreaming;
	this.genere=genere;
	


}

}
