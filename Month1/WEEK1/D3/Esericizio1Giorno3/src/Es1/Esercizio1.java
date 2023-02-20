/**
 * 
 */
package Es1;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Utente
 *
 */
public class Esercizio1 {

	private static Scanner scanner;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		//PariDispari
		inputStringPariDispari();
		scanner.close();
		//anno Bisestile
		if(annoBisestile(2000)){
			System.out.println("L'anno è bisestile");
		}else {
			System.out.println("L'anno non è bisestile");
		}
	}
	private static void inputStringPariDispari() {
		
	//	Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire la stringa da controllare");
		String s = scanner.nextLine();
		if(stringaPariDispari(s)) {
			System.out.println("La stringa "+ s + " ha un numero di caratteri pari");
		}else {
			System.out.println("la stringa "+ s+ " ha un numero di caratteri dispari");
		}
	scanner.close();
	}
	
	public static boolean stringaPariDispari(String s) {
		return (s.length()%2 ==0);
			}
	private static boolean annoBisestile(int anno) {
		/*if(anno %4 ==0) {
			return true;
		}
		if(annoo %100 ==0 &&anno %400 ==0) {
			return true;
		}
		return false;*/
		return (anno % 4 == 0) || (anno % 100 == 0 && anno % 400 == 0);
	};
}