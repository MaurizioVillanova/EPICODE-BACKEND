/**
 * 
 */
package Es1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Utente
 *
 */
public class Esercizio1D2W2 {

	private static Scanner s;
	private static Set<String> parole = new HashSet<String>();
	private static Set<String> duplicate = new HashSet<String>();
	private static Set<String> u = new HashSet<String>();
	public static void main(String[] args) {
		s = new Scanner(System.in);
		//chiedere n
		System.out.println("Inserire n");
		int n = Integer.parseInt(s.nextLine());
				//chiedere n parole
				for(int i= 0; i < n; i++){
					chiediParola();
				}
		//trovare parole uniche
		trovaUniche();
		//visualizza duplicati
	visualizzaDuplicati();
		//visualizza n uniche
	visulaizzaNUniche();
		// visualizza le parole uniche
		visualizzaUniche();
		
		s.close();
	}
	private static void chiediParola() {
		System.out.println("InserireParola");
		String p = s.nextLine();
		if(!parole.add(p)) {
			duplicate.add(p);
		}
	}
	private static void visualizzaDuplicati() {
		System.out.println("parole duplicate "+duplicate);
		
	}
	private static void visulaizzaNUniche() {
		System.out.println("visualizzazioni uniche n "+ u.size());
		
	}
	private static void visualizzaUniche() {
		/*Set<String> u = new HashSet<String>();
		for(String p : parole) {
			if(!contiene(p)) {
				u.add(p);
			}
		}*/
		System.out.println("visualizzazioni uniche "+ " "+u);
		
	}
	private static void trovaUniche() {
		
		for(String p : parole) {
			if(!contiene(p)) {
				u.add(p);
			}
		}
	}
	private static boolean contiene(String p) {
		for(String d : duplicate) {
			if(p.equals(d))
				return true;
		}
		return false;
	}
}
		
		