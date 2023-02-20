/**
 * 
 */
package Esercizi;

/**
 * @author Utente
 *
 */
public class Esercizio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sim s1 = new Sim("3713394492");
		Sim s2 = new Sim("3764529987");
		Sim s3 = new Sim("33187650924");
		s1.datiSim();
		s1.ricarica(10);
		s1.visualizzazioniChiamate();
		s1.chiamata(s2);
		s1.chiamata(s3);
		s2.chiamata(s1);
		s2.chiamata(s3);
		s2.visualizzazioniChiamate()
	}

}
