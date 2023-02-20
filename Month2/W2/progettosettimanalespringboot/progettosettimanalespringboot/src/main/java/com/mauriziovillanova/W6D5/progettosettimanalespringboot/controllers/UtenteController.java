package com.mauriziovillanova.W6D5.progettosettimanalespringboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Utente;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.service.UtenteService;
@RestController
@RequestMapping("/api")
public class UtenteController {
	@Autowired
	private UtenteService utenteSrv;
	
	
		@GetMapping("/utente")public ResponseEntity<List<Utente>>getAllUtente(){
			List<Utente> utente = utenteSrv.getaAll();
			if(!utente.isEmpty()) {
				return new ResponseEntity<>(utente, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@PostMapping("/utente")
		public ResponseEntity<Utente> aggiungiUtente(@RequestBody Utente utente){
			Utente nuovoUtente = utenteSrv.save(utente);
			if(nuovoUtente != null) {
				return new ResponseEntity<>(nuovoUtente, HttpStatus.CREATED);
	}else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
		}
		@GetMapping("/utente/{id}")
		public ResponseEntity<Utente> getOneUtente(@PathVariable int id){
			Optional<Utente> utente = utenteSrv.getById(id);
			if (utente.isPresent()) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@DeleteMapping("/utente/{id}")
		public ResponseEntity<Void> deleteUtente(@PathVariable int id){
			boolean cancel = utenteSrv.deleteById(id);
			if(cancel) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@PutMapping("/utente/{id}")
		public ResponseEntity<Utente> updateUtente(@PathVariable int id, @RequestBody Utente u){
			Optional<Utente> utente = utenteSrv.getById(id);
			if(utente.isPresent()) {
				Utente updateUtente = utenteSrv.update(id, u);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
