/**
 * 
 */
package GestioneDipendenti;


public class GestioneDipendenti {

	
	public static void main(String[] args) {
		Dipendente d1 = new Dipendente("Pasquale", 1234,   Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente("Nicola", 1235,  Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente("Giovanni", 1236,  Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente("Antonio", 1237,  Dipartimento.VENDITE);
		
		d1.stampaDipendente();
		d1.promotion();
		d1.promotion();
		d1.getStipendio(d1, 5);
		
		d2.stampaDipendente();
		d2.getStipendio(d2, 5);
		
		d3.stampaDipendente();
		d3.promotion();
		d3.getStipendio(d3, 5);
		
		d4.stampaDipendente();
		d4.getStipendio(d4, 5);
	}
	}


