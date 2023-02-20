package Es;

import java.time.LocalDate;
import java.util.List;

public class Ordine {
	   long id;
	    StatoOrdine status = StatoOrdine.CONFERMATO;
	    LocalDate dataOrdine = LocalDate.now();
	    LocalDate dataSpedizione;
	    List<Prodotto> prodotti;
	    Cliente cliente;

	    public Ordine(long id,  List<Prodotto> prodotti, Cliente cliente) {
	        this.id = id;
	        this.prodotti = prodotti;
	        this.cliente = cliente;
	    }

	    @Override
	    public String toString() {
	        return "" + this.cliente.getLivello();
	    }

	    public Cliente getCliente() {
	        return cliente;
	    }

	    public List<Prodotto> getProdotti() {
	        return prodotti;
	    }
	}