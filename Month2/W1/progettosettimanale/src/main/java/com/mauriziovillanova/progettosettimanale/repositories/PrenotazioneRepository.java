package com.mauriziovillanova.progettosettimanale.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mauriziovillanova.progettosettimanale.entities.Postazione;
import com.mauriziovillanova.progettosettimanale.entities.Prenotazione;
import com.mauriziovillanova.progettosettimanale.entities.User;



public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	 @Query(
	            value = "SELECT p FROM Prenotazione p WHERE (p.user = :u AND p.data = :d) OR (p.postazione = :p AND " +
	                    "p.data= :d)"
	    )
	    public List<Prenotazione> findPrenotazioneByTipo( @Param( "u" ) User u, @Param( "d" ) LocalDate d,
	                                                      @Param( "p" ) Postazione p);
}
