package entities.part2;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import entities.evento;
import enumm.tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="calcio")

@NoArgsConstructor
@DiscriminatorValue("calcietto")
@Getter
@Setter
public class PartitaDiCalcio extends evento {
private  String squadraCasa;
private  String squadraOspite;
private  String SquadraVincente=null;
private  int golSquadraCasa;
private  int golSquadraOspite;
public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti,
		tipo tipoEvento,String squadraCasa, String squadraOspite, int golSquadraCasa,
		int golSquadraOspite) {
	super(titolo,dataEvento,descrizione,numeroMassimoPartecipanti,
	tipoEvento);
	this.squadraCasa=squadraCasa;
	this.squadraOspite=squadraOspite;
	this.golSquadraCasa=golSquadraCasa;
	this.golSquadraOspite=golSquadraOspite;
	


}










}