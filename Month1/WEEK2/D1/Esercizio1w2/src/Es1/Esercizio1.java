/**
 * 
 */
package Es1;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Utente
 *
 */
public class Esercizio1 {

	   private static final Logger logger = LoggerFactory.getLogger( Esercizio1.class );
	    private int[] myArray = new int[ 5 ];

	    public Esercizio1()
	    {
	        setMyArray();
	    }

	    public void setMyArray()
	    {
	        for( int i = 0 ; i < myArray.length ; i++ ) {
	            myArray[ i ] = ( int ) Math.floor( Math.random() * 10 + 1 );
	        }
	    }

	    @Override
	    public String toString()
	    {
	        return Arrays.toString( myArray );
	    }

	    public void gameArray()
	    {
	        Scanner scanner = new Scanner( System.in );

	        int[] array = new int[ 5 ];

	        boolean loop = true;

	        do {
	            System.out.println( Arrays.toString( myArray ) );
	            System.out.println( " Inserisci la posizione da modificare, posizioni accettate: 0 - 4" );


	            int posizione = 0;
	            boolean posizioneCheck = true;

	            while( posizioneCheck ) {
	                try {
	                    posizione = scanner.nextInt();
	                    if( posizione < 0 || posizione > 10 ) {
	                        logger.error( "Posizione inserita non valida, riprova!" );
	                    } else {
	                        posizioneCheck = false;
	                    }
	                } catch( Exception e ) {
	                    System.out.println( "Errore durante l'inserimento dell'indice, riprova!" );
	                    scanner.nextLine();
	                }
	            }

	            System.out.println( "Quale numero vuoi inserire alla posizione " + posizione + "? Solo numeri da 1 a 10, 0 " +
	                    "per uscire." );

	            int elementoPrima = myArray[ posizione ];
	            int elemento = 0;
	            boolean elementoCheck = true;

	            while( elementoCheck ) {
	                try {
	                    elemento = scanner.nextInt();
	                    if( elemento < 0 || elemento > 10 ) {
	                        logger.error( "Posizione inserita fuori dal range, array non modificato, riprova!" );
	                        elemento = elementoPrima;
	                    } else {
	                        elementoCheck = false;
	                    }

	                } catch( Exception e ) {
	                    logger.error( "Errore durante l'inserimento dell'elemento, array non modificato, riprova!" );
	                    scanner.nextLine();
	                }
	            }

	            if (elemento == 0) {
	                logger.info("Arrivederci!");
	                loop = false;
	            } else {
	                for( int i = 0 ; i < myArray.length ; i++ ) {
	                    if( i == posizione ) {
	                        array[ i ] = elemento;
	                    } else {
	                        array[ i ] = myArray[ i ];
	                    }
	                }
	                myArray = array;
	                System.out.println( "FATTO!" );
	            }
	            

	            
	        } while( loop );

	    }
	}

