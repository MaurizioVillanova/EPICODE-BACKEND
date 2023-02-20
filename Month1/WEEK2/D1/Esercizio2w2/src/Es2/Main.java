/**
 * 
 */
package Es2;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	   private static final Logger logger = LoggerFactory.getLogger ( Esercizio2.class );
	
	public static void main(String[] args) {
		   Scanner scanner = new Scanner ( System.in );
	        boolean loop = true;

	        while (loop) {
	            try {
	                System.out.println ( "Inserisci il numero di km: " );
	                double km = scanner.nextDouble ();
	                System.out.println ("Inserisci i litri consumati: " );
	                double litri = scanner.nextDouble();

	                if (km < 1 || litri < 1) {
	                    logger.error ("I litri o i km non possono essere 0!");
	                    loop = false;
	                } else {
	                    Esercizio2 es2 = new Esercizio2(km, litri);
	                    es2.getConsumo ();
	                }
	            } catch (Exception e) {
	                logger.error ("" + e.getMessage());
	                scanner.nextLine ();
	            }

	        }


	    }
	}
