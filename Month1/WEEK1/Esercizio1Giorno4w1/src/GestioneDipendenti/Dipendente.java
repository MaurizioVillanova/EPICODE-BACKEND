package GestioneDipendenti;

public class Dipendente {
	private static double stipendioBase = 1000.0;
	private int matricola;
	private String nome;
	private static double stipendio;
	private int importoOrarioStraordinario;
	private static Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(String nome, int matricola, Dipartimento dipartimento ) {
		this.matricola = matricola;
		this.nome = nome;
		this.dipartimento = dipartimento;
		setStipendio();
		importoOrarioStraordinario = 30;
		livello = Livello.OPERAIO;

	}
	public Dipendente(String nome, int matricola, int importoOrarioStraordinario,
			Livello livello, Dipartimento dipartimento) {

		this.nome = nome;
		this.matricola = matricola;
		setStipendio();
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	// CALCOLA LO STIPENDIO
	
		private void setStipendio() {
			
			double newStipendio = 0;

			if (livello == Livello.IMPIEGATO) {
				newStipendio = stipendioBase * 1.2;
			} else if (livello == Livello.QUADRO) {
				newStipendio = stipendioBase * 1.5;
			} else if (livello == Livello.DIRIGENTE) {
				newStipendio = stipendioBase * 2;
			} else {
				newStipendio = stipendioBase;
			}
			stipendio = newStipendio;
		}
		public void getStipendio(Dipendente dip, int ore) {
			System.out.printf("Totale più straordinario: ");
			System.out.println( stipendio + (ore * 30) + "\n" );
		}
		// PROMOZIONE
public Livello promotion(){
			
	        if(livello == Livello.DIRIGENTE){
	            System.out.println("Livello massimo");
	        } else if (livello == Livello.QUADRO) {
	            livello = Livello.DIRIGENTE;
	        }else if (livello == Livello.IMPIEGATO) {
	            livello = Livello.QUADRO;
	        }else {livello = Livello.IMPIEGATO;}

	        setStipendio();
	        
	        return livello;
	    }
	
	// STAMPA IL DIPENDENTE
	
	public void stampaDipendente() {
		System.out.println("Nome: " + nome + "\nMatricola: "+ matricola + "\nLivello: " + livello + "\nDipartimento: " + dipartimento + "\nStipendio: "
				+ stipendio);
	}

	}
/* Esercizio #1
Scrivere la classe Dipendente che ha i seguenti attributi:

Attributi statici
- stipendioBase - numero decimale con stipendio base mensile prevalorizzato a 1000 accessibile a tutte le classi

- matricola - identificativo univoco del dipendente
- stipendio - numero decimale con stipendio base mensile calcolato per il dipendente
- importoOrarioStraordinario - numero decimale con importo per ogni ora di straordinario
- Livello - valori possibili [OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE]
- Dipartimento - Valori possibili [PRODUZIONE, AMMINISTRAZIONE, VENDITE]

Le proprietÃ  devono essere accessibili solo dalla classe Dipendente e deve essere possibile leggerle tramite opportuni metodi get ma non modificarle, tranne le proprietÃ  Dipartimento e importoOrarioStraordinario  che possono essere modificate da altre classi tramite un metodo di set.

Definire due costruttori: 
- uno che accetti solo la matricola e Dipartimento ed imposti i seguenti valori
	- stipendio = stipendioBase
	- importoOrarioStraordinario = 30
	- Livello = OPERAIO
- Uno che accetti tutti i parametri

Definire i seguenti metodi
- stampaDatiDipendente - Stampa i dati del dipendente
- promuovi - aggiorna il livello del dipendente con la seguente logica 
	se il Dipendente Ã¨ operaio lo promuove a impiegato
	se il Dipendente Ã¨ impiegato lo promuove a quadro
	se il Dipendente Ã¨ quadro lo promuove a dirigente
	se il Dipendente Ã¨ dirigente resta tale e scrive un messaggio di errore
  Il metodo aggiorna inoltre lo stipendio del dipendente con la seguente logica
	- IMPIEGATO = stipendioBase * 1,2
	- QUADRO = stipendioBase * 1,5
	- DIRIGENTE = stipendioBase * 2
 Infine il metodo ritorna il nuovo livello del dipendente

Definire i seguenti metodi statici:
- calcolaPaga - accetta un'istanza di dipendente e ne ritorna lo stipendio mensile
- calcolaPaga - accetta un'istanza di dipendente ed un parametro intero con le ore di straordinario e ritorna lo stipendio mensile comprensivo di straordinario*/

