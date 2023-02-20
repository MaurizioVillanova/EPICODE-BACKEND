/**
 * 
 */
package Esercizio3;


public class ContoOnLine extends ContoCorrente {

	  double maxPrelievo;

	    public ContoOnLine ( String titolare, double saldo, double maxP ) {
	        super(titolare, saldo);
	        this.maxPrelievo = maxP;
	    }

	    public void stampaSaldo () {

	        System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
	                + " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	    }

	    public void preleva(double x ) {
	        try {
	            if (x <= maxPrelievo) {
	              super.preleva(x);
	            } else {
	                throw new BancaException( "Non puoi prelevare più di " + maxPrelievo);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	}



