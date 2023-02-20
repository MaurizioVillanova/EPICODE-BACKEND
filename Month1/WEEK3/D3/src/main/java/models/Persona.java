package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cognome;

    private String email;

    private String datadinascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    // dentro una sola persona avremo diverse partecipazioni salvate, ma una partecipazione avrà solo una persona
    // quindi oneToMany, nella partecipazione avremmo il ManyToOne collegato a persona
    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
   @OrderBy(value = "evento.data")
    private List<Partecipazione> listapartecipazioni;

    public Persona( String nome, String cognome, String email, String datadinascita, Sesso sesso ) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datadinascita = datadinascita;
        this.sesso = sesso;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", datadinascita='" + datadinascita + '\'' +
                ", sesso=" + sesso +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome( String cognome ) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita( String datadinascita ) {
        this.datadinascita = datadinascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso( Sesso sesso ) {
        this.sesso = sesso;
    }
}
