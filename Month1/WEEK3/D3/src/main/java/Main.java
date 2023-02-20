import models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main( String[] args ) {
//        insertEvento( "Rave Party sulla spiaggia", "23/12/2022", "Dopo pulite tutto", TipoEvento.PUBBLICO, 1000, 1 );
//        insertPersona( "Roberto", "Balestra", "robybale@acido.com", "15/04/1976", Sesso.MASCHIO );
//        insertLocation( "Piramide di Giza", "Egitto" );
//        System.out.println(findPersonId( 1 ));
//        System.out.println(findEventoId( 5 ));
//        insertPartecipazione(1,  5);
//        eliminaEvento( 5 );

    }

    public static void eliminaEvento(int idEvento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Evento evento = findEventoId( idEvento );

        em.remove(evento);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertEvento(String titolo, String data, String descrizione, TipoEvento tipoEvento,
                                    int numeropartecipanti, int locationId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        Evento evento = new Evento(titolo, data, descrizione, tipoEvento, numeropartecipanti, findLocationId( locationId ));
        et.begin();

        em.persist(evento);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertPersona(String nome, String cognome, String email, String datadinascita, Sesso sesso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Persona persona = new Persona(nome, cognome, email, datadinascita, sesso);

        em.persist(persona);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertLocation(String nome, String citta) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Location location = new Location(nome, citta);

        em.persist(location);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertPartecipazione(int idPersona, int idEvento) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Partecipazione partecipazione = new Partecipazione(findPersonId( idPersona ), findEventoId( idEvento ));

        em.persist(partecipazione);
        et.commit();

        em.close();
        emf.close();
    }

    public static Persona findPersonId(int id) {
        Persona personaFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Persona p = em.find(Persona.class, id);

        if(p != null) {
            personaFind = p;
        }

        em.close();
        emf.close();
        return personaFind;
    }

    public static Evento findEventoId(int id) {
        Evento eventoFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Evento p = em.find(Evento.class, id);

        if(p != null) {
            eventoFind = p;
        }

        em.close();
        emf.close();
        return eventoFind;
    }

    public static Location findLocationId(int id) {
        Location locationFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        Location p = em.find(Location.class, id);

        if(p != null) {
            locationFind = p;
        }

        em.close();
        emf.close();
        return locationFind;
    }



}
