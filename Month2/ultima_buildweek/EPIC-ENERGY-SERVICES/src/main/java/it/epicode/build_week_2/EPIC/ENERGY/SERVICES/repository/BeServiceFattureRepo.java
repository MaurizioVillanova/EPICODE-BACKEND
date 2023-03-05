package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceFatture;


@Repository
public interface BeServiceFattureRepo extends JpaRepository<BeServiceFatture, Long>{
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_fatture WHERE cliente_id = :clienteId"
        )
        Page<BeServiceFatture> findByClienteId(@Param("clienteId") Long clienteId, Pageable pageable);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM be_service_fatture WHERE anno = :anno")
    Page<BeServiceFatture> findByAnno(@Param("anno") Long anno,
            Pageable pageable);

	@Query(nativeQuery = true, value = "SELECT f.* FROM be_service_fatture f JOIN be_service_stato_fattura sf ON f.stato_id = sf.id WHERE LOWER(sf.nome) = LOWER(:nome)")
	Page<BeServiceFatture> findByStato(@Param("nome") String nome, Pageable pageable);

	
	@Query(nativeQuery = true, value = "SELECT * FROM be_service_fatture WHERE importo BETWEEN :minImporto AND :maxImporto")
	Page<BeServiceFatture> findByImportoBetween(@Param("minImporto") BigDecimal minImporto, @Param("maxImporto") BigDecimal maxImporto, Pageable pageable);

	@Query(value = "SELECT * FROM public.be_service_fatture WHERE data >= :startDate ORDER BY data DESC", nativeQuery = true)
    Page<BeServiceFatture> findFatturaByData(@Param("startDate") Timestamp startDate, Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT f.* FROM be_service_fatture f JOIN be_service_clienti c ON c.id = f.cliente_id WHERE LOWER(c.nome_contatto) = LOWER(:nome)")
    List<BeServiceFatture> findFattureByClienteNome(@Param("nome") String nome);
}
