/**
 * 
 */
package it.rinomarra.chainofresponsibility;

/**
 * @author Rino
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ufficiali
		Capitano capitano = new Capitano();
		Maggiore maggiore = new Maggiore();
		Tenente tenente = new Tenente();
		Colonnello colonnello = new Colonnello();
		Generale generale = new Generale();

		// creazione della gerarchia
		capitano.setSuperiore(maggiore);
		maggiore.setSuperiore(tenente);
		tenente.setSuperiore(colonnello);
		colonnello.setSuperiore(generale);

		System.out.println("Chi guadagna almeno 4500 euro al mese ? ");
		capitano.check(4500);

	}

}
