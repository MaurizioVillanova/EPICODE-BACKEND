package it.epicode.be.godfather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.godfather.model.PizzaTopping;

public interface PizzaToppingRepository extends JpaRepository<PizzaTopping, Long>{
	
	

}
