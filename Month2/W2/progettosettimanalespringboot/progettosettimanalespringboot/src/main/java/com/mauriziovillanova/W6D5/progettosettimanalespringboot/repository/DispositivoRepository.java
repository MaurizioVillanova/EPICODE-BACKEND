package com.mauriziovillanova.W6D5.progettosettimanalespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.Dispositivo;
@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer>{

	

}
