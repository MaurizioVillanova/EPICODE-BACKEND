package com.mauriziovillanova.W6D5.progettosettimanalespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Ruolo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.repository.RuoloRepository;

@Service
public class RuoloService {
	@Autowired
	private RuoloRepository ruoloRepo;
	
	public Ruolo save(Ruolo r) {
		return ruoloRepo.save(r);
	}
}

