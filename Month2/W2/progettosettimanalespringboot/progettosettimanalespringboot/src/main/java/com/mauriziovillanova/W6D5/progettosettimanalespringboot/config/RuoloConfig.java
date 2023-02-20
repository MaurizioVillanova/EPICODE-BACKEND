package com.mauriziovillanova.W6D5.progettosettimanalespringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Ruolo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.TipoRuolo;

@Configuration
public class RuoloConfig {

	@Bean
	@Scope("prototype")
	public Ruolo RuoloAmministratore(){
		return Ruolo.builder().tipo(TipoRuolo.AMMINISTRATORE).build();
	}
	@Bean
	@Scope("prototype")
	public Ruolo RuoloUtente(){
		return Ruolo.builder().tipo(TipoRuolo.UTENTE).build();
	}
}
