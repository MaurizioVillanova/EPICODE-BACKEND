package it.epicode.be.godfather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long>{
	
	

}
