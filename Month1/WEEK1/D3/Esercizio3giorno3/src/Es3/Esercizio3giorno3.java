/**
 * 
 */
package Es3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Utente
 *
 */
public class Esercizio3giorno3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  plays();
	}
	   static void plays() {
	        String str = "";

	        while (!str.equals(":p")) {
	            @SuppressWarnings("resource")
	            Scanner myObj = new Scanner(System.in);
	            System.out.println("Scrivi qualcosa: ");

	            String userName = myObj.nextLine();  // Read user input
	            str = userName;
	            String[] good = str.split("");

	            System.out.println("Username is: " + Arrays.toString(good));  // Output user input

	        }
	    }
}
