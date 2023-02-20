package com.mauriziovillanova.progettosettimanale;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mauriziovillanova.progettosettimanale.entities.Citta;
import com.mauriziovillanova.progettosettimanale.entities.Edificio;
import com.mauriziovillanova.progettosettimanale.entities.Postazione;
import com.mauriziovillanova.progettosettimanale.entities.Prenotazione;
import com.mauriziovillanova.progettosettimanale.entities.Tipo;
import com.mauriziovillanova.progettosettimanale.entities.User;
import com.mauriziovillanova.progettosettimanale.services.CittaService;
import com.mauriziovillanova.progettosettimanale.services.EdificioService;
import com.mauriziovillanova.progettosettimanale.services.PostazioneService;
import com.mauriziovillanova.progettosettimanale.services.PrenotazioneService;
import com.mauriziovillanova.progettosettimanale.services.UserService;

@SpringBootApplication
public class ProgettosettimanaleApplication implements CommandLineRunner {
	@Autowired
	UserService us;
	@Autowired
	CittaService cs;
	@Autowired
	EdificioService es;
	@Autowired
	PostazioneService ps;
	@Autowired
	PrenotazioneService prs;
	public static void main(String[] args) {
		SpringApplication.run(ProgettosettimanaleApplication.class, args);
		System.out.println("hello");
	}
	@Override
	public void run(String... args) throws Exception {
		//insertUser(User.builder().username(" Bardo").nomeCompleto("Marco Brandi").email("marcobrandi").build());
		
		//insertCitta(Citta.builder().name("Tokyo").build());
		//insertEdificio(Edificio.builder().name("Massaggi").address("Via della felicità").citta(cs.findCittaById(52L)).build());
		//insertPostazione(Postazione.builder().tipo(Tipo.SALARIUNIONI).maxSize(15).description("massaggi").edificio(es.findEdificioById(5L)).build());
		//System.out.println(ps.getByTipoAndCitta(Tipo.SALARIUNIONI, cs.findCittaById(52L)));
		//insertPrenotazione(us.findUserById(3L),ps.findPostazioneById(3L),LocalDate.now());


}
	public void insertUser(User u){
		us.addUser(u);
	}
	public void insertCitta(Citta c){
		cs.addCitta(c);
	}
	public void insertEdificio(Edificio e){
		es.addEdificio(e);
	}
	public void insertPostazione(Postazione p){
		ps.addPostazione(p);
	}
	public void insertPrenotazione(User u, Postazione p, LocalDate d){
		prs.realAddPrenotazione(u,p,d);
	}


}

