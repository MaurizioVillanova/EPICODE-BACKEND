package it.rinomarra.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sezione extends ComponenteLibro {

	private String titoloSezione;
	protected List<ComponenteLibro> listaComponenti = new ArrayList<ComponenteLibro>();
	
	public Sezione(String titoloSezione) {
		this.titoloSezione = titoloSezione;
	}

	@Override
	public void stampa() {
		System.out.println("Sezione: " + titoloSezione);
		listaComponenti.forEach(com -> com.stampa());
	}

	/**
	 * @return the titoloSezione
	 */
	public String getTitoloSezione() {
		return titoloSezione;
	}

	/**
	 * @param titoloSezione the titoloSezione to set
	 */
	public void setTitoloSezione(String titoloSezione) {
		this.titoloSezione = titoloSezione;
	}

	/**
	 * @return the listaComponenti
	 */
	public List<ComponenteLibro> getListaComponenti() {
		return listaComponenti;
	}

	/**
	 * @param listaComponenti the listaComponenti to set
	 */
	public void setListaComponenti(List<ComponenteLibro> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}

	@Override
	public int getNumeroPagine() {
		Integer numeroPagine = listaComponenti.stream()
				.collect(Collectors.summingInt(ComponenteLibro::getNumeroPagine));
		return numeroPagine;
	}

}