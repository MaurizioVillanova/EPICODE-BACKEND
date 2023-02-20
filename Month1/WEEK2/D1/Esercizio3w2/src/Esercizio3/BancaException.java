/**
 * 
 */
package Esercizio3;


public class BancaException extends Exception {
	 private String msg;
	    public BancaException(String str) {
	        super(str);
	        this.msg = str;
	    }

	    @Override
	    public String toString() {
	        return "BANCAEXCEPTION - " + this.msg;
	    }
	}
