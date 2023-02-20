package com.mauriziovillanova.W6D5.progettosettimanalespringboot.securities;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Ruolo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Utente;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.service.UtenteService;

import lombok.AllArgsConstructor;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UtenteService untenteSrv;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/api/**").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/dispositivo/**").hasRole("AMMINISTRATORE")
		.antMatchers(HttpMethod.POST, "/api/dispositivo/**").hasRole("AMMINISTRATORE")
		.antMatchers(HttpMethod.DELETE, "/api/dispositivo/**").hasRole("AMMINISTRATORE")
		.and()
		.formLogin()
		.successForwardUrl("/api/dispositivo")
		.and()
		.logout()
		.and()
		.csrf().disable();
		
	}
	@Override
	protected void configure (final AuthenticationManagerBuilder auth)throws Exception {
		Optional<Utente> authUserObj = untenteSrv.getById(3);
		Utente authUser = authUserObj.get();
		String role = "UTENTE";
		Set<Ruolo> roles = authUser.getRuoli();
		
		for(Ruolo r : roles) {
			if(r.getTipo().toString().contains("AMMINISTRATORE")) {
				role = "AMMINISTRATORE";
				break;
			}
			
		}
		auth.inMemoryAuthentication()

	.withUser(authUser.getUsername()).password(passwordEncoder().encode(authUser.getPassword()))
	.roles(role);
		}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
