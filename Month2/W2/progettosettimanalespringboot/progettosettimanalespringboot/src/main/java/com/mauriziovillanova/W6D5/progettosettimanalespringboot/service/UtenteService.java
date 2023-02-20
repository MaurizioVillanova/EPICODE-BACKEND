package com.mauriziovillanova.W6D5.progettosettimanalespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Dispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Utente;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepo;
	public Utente save(Utente u) {
		return utenteRepo.save(u);
	}
	public List<Utente> getaAll(){
		return utenteRepo.findAll();
	}
	public Optional<Utente> getById(int id){
		return utenteRepo.findById(id);
	}
	 public boolean deleteById(int id) {
		 utenteRepo.deleteById(id);
		 return true;
	 }
	 public Utente update(int id, Utente utente) {
		 Optional<Utente> utenteDaAggiornare = utenteRepo.findById(id);
		 if(utenteDaAggiornare.isPresent()) {
			Utente utenteAggiornato = utenteDaAggiornare.get();
				utenteAggiornato.setNome(utente.getNome());
				utenteAggiornato.setCognome(utente.getCognome());
				utenteAggiornato.setUsername(utente.getUsername());
				utenteAggiornato.setPassword(utente.getPassword());
				return utenteRepo.save(utenteAggiornato);
		
		 }else {
			 return null;
		 }
	 }
}
