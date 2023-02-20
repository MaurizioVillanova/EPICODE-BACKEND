package it.epicode.be.godfather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.godfather.model.Franchise;

public interface FranchiseRepository extends JpaRepository<Franchise, Long>{
	
	

}
