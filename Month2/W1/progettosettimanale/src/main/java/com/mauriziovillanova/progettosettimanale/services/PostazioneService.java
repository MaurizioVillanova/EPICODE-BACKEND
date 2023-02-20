package com.mauriziovillanova.progettosettimanale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.progettosettimanale.entities.Citta;
import com.mauriziovillanova.progettosettimanale.entities.Postazione;
import com.mauriziovillanova.progettosettimanale.entities.Tipo;
import com.mauriziovillanova.progettosettimanale.repositories.PostazioneRepository;

@Service
public class PostazioneService {
	 @Autowired
	    PostazioneRepository prr;

	    public void addPostazione(Postazione p) {
	        prr.save(p);
	    }

	    public List<Postazione> getAll() {
	        return prr.findAll();
	    }

	    public Postazione findPostazioneById(Long id){
	        return prr.findById(id).isPresent() ? prr.findById(id).get() : null;
	    }

	    public List<Postazione> getByTipoAndCitta(Tipo tipo, Citta citta){return prr.findPostazioneByTipoAndCitta(tipo, citta);}
}
