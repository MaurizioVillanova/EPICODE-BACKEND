package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceClienti;

@Repository
public interface BeServiceClientiRepo extends JpaRepository<BeServiceClienti, Long>{
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE LOWER(nome_contatto) = LOWER(:nome)")
        List<BeServiceClienti> findByName(@Param("nome") String nome);
	
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE fatturato_annuale = :fatt")
    List<BeServiceClienti> findByFatturato(@Param("fatt") double fatt);
	
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE nome_contatto LIKE %:nome%"
        )
        Page<BeServiceClienti> findByNameContaining(@Param("nome") String nome, Pageable pageable);
	
	
	@Query(value = "SELECT * FROM be_service_clienti WHERE fatturato_annuale > :fatturato", 
		       countQuery = "SELECT count(*) FROM be_service_clienti WHERE fatturato_annuale > :fatturato", 
		       nativeQuery = true)
		Page<BeServiceClienti> findByFatturatoMaggioreDi(@Param("fatturato") Double fatturato, Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti " +
            "JOIN be_service_indirizzi ON indirizzo_sede_legale_id = be_service_indirizzi.id " +
            "JOIN be_service_comuni ON be_service_indirizzi.comune_id = be_service_comuni.id " +
            "JOIN be_service_province ON be_service_comuni.provincia_id = be_service_province.id " +
            "WHERE LOWER(be_service_province.sigla) = LOWER(:sigla)", 
           nativeQuery = true)
		Page<BeServiceClienti> findByProvincia(@Param("sigla") String sigla, Pageable pageable);
	
	//------------------------------------------------------------------QUERY DATA INSERIMENTO------------------------------------------------------
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_inserimento >= :startDate ORDER BY data_inserimento DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataInserimentoAfter1(@Param("startDate") Timestamp startDate, Pageable pageable);
	
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_inserimento <= :startDate ORDER BY data_inserimento DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataInserimentoBefore(@Param("startDate") Timestamp startDate, Pageable pageable);
		
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_inserimento >= :startDate AND data_inserimento <= :endDate ORDER BY data_inserimento DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataInserimentoBetween(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, Pageable pageable);
	
		
		//------------------------------------------------------------------QUERY DATA ULTIMO CONTATTO-------------------------------------------------------------------------
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_ultimo_contatto >= :startDate ORDER BY data_ultimo_contatto DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataUltimoContatto(@Param("startDate") Timestamp startDate, Pageable pageable);
		
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_ultimo_contatto <= :startDate ORDER BY data_ultimo_contatto DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataUltimoContattoBefore(@Param("startDate") Timestamp startDate, Pageable pageable);
		
		@Query(value = "SELECT * FROM public.be_service_clienti WHERE data_ultimo_contatto >= :startDate AND data_ultimo_contatto <= :endDate ORDER BY data_ultimo_contatto DESC", nativeQuery = true)
	    Page<BeServiceClienti> findByDataUltimoContattoBetween(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, Pageable pageable);			
		
	
	
}
