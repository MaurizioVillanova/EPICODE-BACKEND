/**
 * 
 */
package Es;

public class Prodotto {
	
	  long id;
	    String nome;
	    Categoria categoria;
	    double prezzo;

	    public Prodotto(long id, String nome, Categoria categoria, double prezzo) {
	        this.id = id;
	        this.nome = nome;
	        this.categoria = categoria;
	        this.prezzo = prezzo;
	    }

	    public void setPrezzo( double prezzo ) {
	        this.prezzo = prezzo;
	    }

	    @Override
	    public String toString() {
	        return this.nome + " " + this.categoria + " " + this.prezzo;
	    }

	    public double getPrezzo() {
	        return prezzo;
	    }

	    public Categoria getCategoria() {
	        return categoria;
	    }
	}
