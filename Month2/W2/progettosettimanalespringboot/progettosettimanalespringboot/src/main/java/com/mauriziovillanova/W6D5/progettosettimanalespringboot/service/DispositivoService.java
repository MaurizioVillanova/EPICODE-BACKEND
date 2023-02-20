package com.mauriziovillanova.W6D5.progettosettimanalespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Dispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.repository.DispositivoRepository;

@Service
public class DispositivoService {

	 @Autowired
	 private DispositivoRepository dispositivoRepo;
	 
	 public Dispositivo save(Dispositivo d) {
		 return dispositivoRepo.save(d);
		
		 }
	 public List<Dispositivo> getAll(){
		 return dispositivoRepo.findAll();
	 }
	 public Optional<Dispositivo> getById(int id){
		 return dispositivoRepo.findById(id);
	 }
	 public boolean deleteById(int id) {
		 dispositivoRepo.deleteById(id);
		 return true;
	 }
	 public Dispositivo update(int id, Dispositivo dispositivo) {
		 Optional<Dispositivo> dispositivoDaAggiornare = dispositivoRepo.findById(id);
		 if(dispositivoDaAggiornare.isPresent()) {
			Dispositivo dispositivoAggiornato = dispositivoDaAggiornare.get();
				dispositivoAggiornato.setNome(dispositivo.getNome());
				dispositivoAggiornato.setTipo(dispositivo.getTipo());
				dispositivoAggiornato.setStato(dispositivo.getStato());
				return dispositivoRepo.save(dispositivoAggiornato);
		
		 }else {
			 return null;
		 }
	 }
}
