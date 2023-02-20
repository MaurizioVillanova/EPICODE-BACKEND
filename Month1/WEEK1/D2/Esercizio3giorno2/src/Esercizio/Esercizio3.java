/**
 * 
 */
package Esercizio;
/**
 * @author Utente
 *
 */
public class Esercizio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Articolo a1 = new Articolo ("Felpa", 50.5, 1);
		Articolo a2 = new Articolo("Jeans", 30.99, 3);
		Articolo a3 = new Articolo("Camicia", 25, 2);
		Cliente c1 = new Cliente("Paolo", "Bitta", "alfamarusca@gmail.com", "10/02/2015");
		
		Carrello carr1 = new Carrello(c1, new Articolo[] {a1, a2, a3});
	
		System.out.println(carr1.calcoloTotaleCosto());
		
	}
}

class Articolo {
	int codiceArticolo;
	String descrizioneArticolo;
	double prezzo;
	int pezziDisponibili;
	
	Articolo(String descrizioneArticolo, double prezzo, int pezziDisponibili){
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.pezziDisponibili = pezziDisponibili;
	};
};
	class Cliente {
		int codiceCliente;
		String nome;
		String cognome;
		String email;
		String dataIscrizione;
		
		Cliente( String nome, String cognome, String email, String dataIscrizione){
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.dataIscrizione = dataIscrizione;
		};
	};
	class Carrello {
		Cliente clienteAssociato;
		Articolo[] elencoArticoli;
		double totaleCostoArticoli;
		
		Carrello(Cliente clienteAssociato, Articolo[] elencoArticoli){
			this.clienteAssociato = clienteAssociato;
			this.elencoArticoli = elencoArticoli;
		};
		double calcoloTotaleCosto() {
			double totale = 0;
			for (int i =0; i < this.elencoArticoli.length; i ++) {
				totale = totale+ this.elencoArticoli[i].prezzo;
			};
			return totale;
		};
	};

