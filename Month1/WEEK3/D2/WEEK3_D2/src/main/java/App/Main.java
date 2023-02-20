package App;
import java.time.LocalDate;

import javax.persistence.*;

import entities.Evento;
import entities.tipo;
public class Main {
	private static final String persistenceUnit="project1";
    private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
	public static void main(String[] args) {
		editById(3, 50000000);
	}
	public static void insertEvento(  String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti, tipo tipoEvento){ 
		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			e.setTipoEvento(tipoEvento);
			
			t.begin();
            em.persist(e);
            t.commit();
			
			
	}catch(Exception e) {
		
		System.out.println("Errore!");
	}
	}
	public static void deleteEvento(int id) {
		try {
			Evento e = em.find(Evento.class, id);
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(e);
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Errore!");
		}
	}
		public static void getById(int id) {
			try {
				Evento e = em.find(Evento.class, id);
						System.out.println(e.getTitolo()+ " "+ e.getDescrizione()+ " "+ e.getDataEvento()+ " "+ e.getNumeroMassimoPartecipanti()+ " "+ e.getTipoEvento());
		}catch(Exception e) {
			System.out.println("Errore!");
		}
	}
		public static void editById(int id, int n) {
			try {
				Evento e = em.find(Evento.class, id);
				System.out.println("Evento partecipanti: " + e.getNumeroMassimoPartecipanti());
				e.setNumeroMassimoPartecipanti(n);
				em.refresh(e);
				System.out.println("Evento partecipanti: "+ e.getNumeroMassimoPartecipanti());
				
			} finally{
				em.close();
			}
		}
}
