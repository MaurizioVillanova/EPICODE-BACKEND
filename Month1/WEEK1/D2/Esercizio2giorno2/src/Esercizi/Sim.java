package Esercizi;

public class Sim {
		String numeroTelefono;
		double creditoDisponibile;
		Sim[] listaChiamate;
		String[] chiamate;

			Sim(String numeroTelefono){
				this.numeroTelefono = numeroTelefono;
				this.creditoDisponibile = 0;
				this.listaChiamate = new Sim[]{};
				this.chiamate = new String[]{};
			};
			
void datiSim() {
	System.out.println("Il numero di telefono è: "+ this.numeroTelefono);
	System.out.println("iL CREDITO DISPONIBILE è di: "+ this.creditoDisponibile);
	System.out.println("Il numero di chiamate effettuate è di: "+ this.listaChiamate.length);
};

void ricaricaSim(double soldi){
	this.creditoDisponibile = this.creditoDisponibile + soldi;
	System.out.println("Ricarica di: " + soldi + "effetua credito aggiornato "+ this.creditoDisponibile);
};

void chiamata(Sim utente) {
	Sim[] nuovo = new Sim[this.listaChiamate.length + 1];
	String[] chiamata = new String[this.chiamate.length + 1];
	
	double tempo = 0.50;
	double costo = 0.15;
	
	for(int i = 0; i < nuovo.length; i++) {
		if(i < nuovo.length -1) {
		nuovo[i] = this.listaChiamate[i];
		}else {
			nuovo[i] = utente;
		};
	};
	for(int i = 0; i < chiamata.length; i++) {
		if(i < chiamata.length -1) {
			chiamata[i] = this.chiamate[i];
		}else{
			chiamata[i] = "Chiamata effetuata verso: " + utente.numeroTelefono + " durata: " + tempo + " minuti " +"al costo di: " + costo + " euro";
		};
	}
	this.chiamate = chiamata;
	
	this.listaChiamate = nuovo;
};
void visualizzazioniChiamate(){
	for(int i = 0; i < this.listaChiamate.length; i++) {
		System.out.println(listaChiamate[i].numeroTelefono);
		System.out.println(chiamate[i]);
	}
}

}
