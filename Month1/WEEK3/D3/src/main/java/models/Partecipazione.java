package models;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // da una partecipazione avremo una singola persona, ma una persona può avere diverse partecipazioni quindi ManyToOne
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    // da una partecipazione avremo un singolo evento, ma una evento puo avere più partecipazioni quindi ManyToOne
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato = Stato.DA_CONFERMARE;

    public Partecipazione() {}

    public Partecipazione( Persona persona, Evento evento ) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato( Stato stato ) {
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento( Evento evento ) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona( Persona persona ) {
        this.persona = persona;
    }


}
