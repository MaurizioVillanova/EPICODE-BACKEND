package it.epicode.be.prenotazioni;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import it.epicode.be.prenotazioni.model.Edificio;
import it.epicode.be.prenotazioni.repository.EdificioRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class EdificioTests {
	
	@Autowired
	EdificioRepository edificioRepository;

	@Test
	void contextLoads() {
		assertNotNull(edificioRepository);
	}

	@Test
	void testFindBySecurityCode() {
		Page<Edificio> findBySecurityCode = edificioRepository.findBySecurityCode("very secure code 2", null);
		
		findBySecurityCode.get().forEach(e -> log.info("Security: " + e.getSecurityCode() ));

		assertTrue(findBySecurityCode.hasContent());

	}
	
	

}
