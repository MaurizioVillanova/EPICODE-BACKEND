package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceUser;

public interface BeServiceUserRepo extends JpaRepository<BeServiceUser, Long>{
	
	BeServiceUser findByUsername(String username);
    BeServiceUser findByEmail(String email);

}
