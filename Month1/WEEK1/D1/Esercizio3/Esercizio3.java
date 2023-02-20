/**
 * 
 */
package it.epicode.be;

import java.util.Scanner;

/**
 * @author Utente
 *
 */
public class Esercizio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
System.out.println("Inserisci il nome:");
String studentName = in.nextLine();
System.out.println("Inserisci il cognome:");
String studentSurname = in.nextLine();
System.out.println("Inserisci la tua facoltà:");
String studentF = in.nextLine();

System.out.println("hai inserito il tuo nome "+ studentName);
System.out.println("hai inserito il tuo cognome "+ studentSurname);
System.out.println("hai inserito la tua facoltà "+ studentF);
in.close();
	}

}
