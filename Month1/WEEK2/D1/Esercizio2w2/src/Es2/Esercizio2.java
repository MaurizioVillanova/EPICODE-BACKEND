/**
 * 
 */
package Es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Utente
 *
 */
public class Esercizio2 {
	 private static final Logger logger = LoggerFactory.getLogger ( Esercizio2.class );
	    double km;
	    double lt;

	    public Esercizio2(double km, double lt) {
	        setKm ( km );
	        setLt ( lt );
	    }

	    public void getConsumo() {
	        logger.info ("Il consumo km/litri equivale a: " + (km / lt) + " km/litri");
	    }

	    public void setKm ( double km ) {
	        try {
	            if ( km < 1) {
	                logger.error("I km non possono essere 0");
	            } else {
	                this.km = km;
	            }
	        } catch (Exception e) {
	            logger.error(e.getMessage());
	        }

	    }

	    public void setLt ( double lt ) {
	        try {
	            if ( lt < 0) {
	                logger.error("I km non possono essere 0");
	            } else {
	                this.lt = lt;
	            }
	        } catch (Exception e) {
	            logger.error(e.getMessage());
	        }

	    }
	}
