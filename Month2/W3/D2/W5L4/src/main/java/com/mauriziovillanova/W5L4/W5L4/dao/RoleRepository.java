package com.mauriziovillanova.W5L4.W5L4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriziovillanova.W5L4.W5L4.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
