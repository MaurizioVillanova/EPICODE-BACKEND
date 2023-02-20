package com.mauriziovillanova.progettosettimanale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.progettosettimanale.entities.Edificio;
import com.mauriziovillanova.progettosettimanale.repositories.EdificioRepository;


@Service
public class EdificioService {
	  @Autowired
	    EdificioRepository er;

	    public void addEdificio(Edificio e){
	        er.save(e);
	    }

	    public List<Edificio> getAll() {
	        return er.findAll();
	    }

	    public Edificio findEdificioById(Long id){
	        return er.findById(id).isPresent() ? er.findById(id).get() : null;
	    }
}
