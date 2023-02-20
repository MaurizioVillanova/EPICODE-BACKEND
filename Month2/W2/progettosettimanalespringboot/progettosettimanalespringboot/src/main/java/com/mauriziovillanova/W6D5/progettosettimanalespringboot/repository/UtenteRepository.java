package com.mauriziovillanova.W6D5.progettosettimanalespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Utente;
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
