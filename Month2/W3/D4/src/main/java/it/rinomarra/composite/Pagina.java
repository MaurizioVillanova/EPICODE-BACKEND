package it.rinomarra.composite;

public class Pagina extends ComponenteLibro {
	
private int numeroPagina;
		
	public Pagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
		
	}
	@Override
	public int getNumeroPagine() {
		if(this.numeroPagina < 1) {
			return -1;
		} else return this.numeroPagina;
	}

	@Override
	public void stampa() {
		System.out.println("Stampa pagina: " + numeroPagina);		
	}

}

