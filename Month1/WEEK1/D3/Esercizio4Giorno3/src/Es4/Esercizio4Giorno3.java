/**
 * 
 */
package Es4;

import java.util.Scanner;

/**
 * @author Utente
 *
 */
public class Esercizio4Giorno3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 counter();
	}
	 static void counter() {
	        Scanner myObj = new Scanner(System.in);
	        System.out.println("Scrivi un numero: ");

	        int numero = Integer.parseInt(myObj.nextLine());

	        for(int i = numero; i >= 0; i-- ) {
	            System.out.println(i);
	        }
	        myObj.close();
	    }
}
