package com.mauriziovillanova.W6D5.progettosettimanalespringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Dispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.StatoDispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.TipoDispositivo;

@Configuration
public class DispositivoConfig {
 @Bean
 @Scope("prototype")
 public Dispositivo dispositivo(String nome, TipoDispositivo tipo, StatoDispositivo stato) {
	 return Dispositivo.builder()
			 .nome(nome)
			 .tipo(tipo)
			 .stato(stato)
			 .build();
 }
}
