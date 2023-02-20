package Biblioteca;

import Enums.Periodicità;

public class Rivista extends Catalogo {

    Periodicità periodicita;

    public Rivista(int codice, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita  ) {

        super(codice, titolo, annoPubblicazione, numeroPagine );
        this.periodicita = periodicita;

    }

    public Rivista( String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita  ) {

        super( titolo, annoPubblicazione, numeroPagine );
        this.setPeriodicita( periodicita );

    }

    @Override
    public String toString() {
        return "ISBN: " + this.getCodiceISBN()
                + " - " + " Titolo: " + this.getTitolo()
                + " - " + " Anno: " + this.getAnnoPubblicazione()
                + " - " + " Pagine: " + this.getNumeroPagine();
    }

    // GETTERS AND SETTERS
    public Periodicità getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita( Periodicità periodicita ) {
        this.periodicita = periodicita;
    }
}

