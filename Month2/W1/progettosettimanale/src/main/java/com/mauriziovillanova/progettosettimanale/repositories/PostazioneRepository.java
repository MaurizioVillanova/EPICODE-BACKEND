package com.mauriziovillanova.progettosettimanale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mauriziovillanova.progettosettimanale.entities.Citta;
import com.mauriziovillanova.progettosettimanale.entities.Postazione;
import com.mauriziovillanova.progettosettimanale.entities.Tipo;





public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
	  @Query(
	            value = "SELECT p FROM Postazione p WHERE p.tipo = :t AND p.edificio.citta = :c"
	    )
	    public List<Postazione> findPostazioneByTipoAndCitta( @Param( "t") Tipo t, @Param( "c" ) Citta c);
}
