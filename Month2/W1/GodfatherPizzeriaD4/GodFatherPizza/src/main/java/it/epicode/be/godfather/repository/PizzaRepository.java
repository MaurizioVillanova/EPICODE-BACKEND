package it.epicode.be.godfather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.godfather.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
	
	

}
