package com.mauriziovillanova.W6D5.progettosettimanalespringboot;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.config.DispositivoConfig;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.config.RuoloConfig;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.config.UtenteConfig;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Dispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Ruolo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Utente;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.StatoDispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.TipoDispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.TipoRuolo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.service.DispositivoService;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.service.RuoloService;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.service.UtenteService;

@SpringBootApplication
public class ProgettosettimanalespringbootApplication implements CommandLineRunner{

	@Autowired
	private DispositivoService dispositivoSrv ;
	@Autowired
	private RuoloService ruoloSrv;
	@Autowired
	private UtenteService utenteSrv;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProgettosettimanalespringbootApplication.class, args);
	}
	@Override
	public void run (String...args) throws Exception{
		popolaDb();
	}
	
	private void popolaDb() {
		ApplicationContext ctxd = new AnnotationConfigApplicationContext(DispositivoConfig.class);
		ApplicationContext ctxr = new AnnotationConfigApplicationContext(RuoloConfig.class);
		ApplicationContext ctxu = new AnnotationConfigApplicationContext(UtenteConfig.class);
		
		// Ruolo r1 = (Ruolo)ctxr.getBean("ruolo", TipoRuolo.AMMINISTRATORE);
		// Ruolo r2 = (Ruolo)ctxr.getBean("ruolo", TipoRuolo.UTENTE);
		 Ruolo r1 = (Ruolo)ctxr.getBean("ruoloAmministratore");
		 Ruolo r2 = (Ruolo)ctxr.getBean("ruoloUtente");
		 Dispositivo d1 = (Dispositivo)ctxd.getBean("dispositivo", "Redminote10", TipoDispositivo.SMARTPHONE,StatoDispositivo.DISPONIBILE);
		 Dispositivo d2 = (Dispositivo)ctxd.getBean("dispositivo", "Samsung Galaxy Book3Pro", TipoDispositivo.LAPTOP,StatoDispositivo.DISMESSO);
		 Utente u1 = (Utente)ctxu.getBean("utente", "Rino", "Marra", "ProfRino", "rinomarra", "rino.marra@gmail.com");
		 u1.setRuoli(new HashSet<>(){{
			 add(r1);
		 }});
		 u1.setDispositivi(new HashSet<>(){{
			 add(d1);
		 }});	
		 d1.setStato(StatoDispositivo.ASSEGNATO);
		 ruoloSrv.save(r1);
		 ruoloSrv.save(r2);
		 utenteSrv.save(u1);
		 ((AnnotationConfigApplicationContext)ctxd).close();
		 ((AnnotationConfigApplicationContext)ctxr).close();
		 ((AnnotationConfigApplicationContext)ctxu).close();
	}
 
}
