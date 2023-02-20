package com.mauriziovillanova.progettosettimanale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauriziovillanova.progettosettimanale.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

}
