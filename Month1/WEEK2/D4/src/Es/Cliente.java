/**
 * 
 */
package Es;



public class Cliente {
	 long id;
	    String nome;
	    int livello;

	    public Cliente(long id, String nome, int livello) {
	        this.id = id;
	        this.nome = nome;
	        this.livello = livello;
	    }

	    @Override
	    public String toString() {
	        return "" + this.livello;
	    }

	    public int getLivello() {
	        return livello;
	    }
	}
