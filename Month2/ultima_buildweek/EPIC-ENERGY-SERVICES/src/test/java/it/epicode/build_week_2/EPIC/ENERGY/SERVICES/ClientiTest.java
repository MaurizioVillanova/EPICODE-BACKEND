package it.epicode.build_week_2.EPIC.ENERGY.SERVICES;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller.BeServiceClientiController;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceClientiRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service.BeServiceClientiService;

class ClientiTest {

	private BeServiceClientiController controller;
	private BeServiceClientiRepo clientiRepo;
	private BeServiceClientiService clientiService;
	
	@BeforeEach
	public void setup() {
		//Stiamo simulando la dependency con le repo/services/controller
		clientiRepo = mock(BeServiceClientiRepo.class);
		clientiService = mock(BeServiceClientiService.class);
		controller = new BeServiceClientiController(clientiService, clientiRepo);
	}
	
	@Test
	public void testGetAllClienti() {
		//Per ricevere uno status code 200 il test passa 
		//e verifica che contenga la stessa lista di BeServiceClienti che abbiamo simulato
		when(clientiService.getAll()).thenReturn(new ArrayList<>());
		ResponseEntity<List<BeServiceClienti>> response = controller.getAll();
		//Altro test che restituisce NOT FOUND
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	//testa clienti in base a sede legale, in questo caso torino
    public void testGetClientiByProvinciaSedeLegale() {
        List<BeServiceClienti> mockClientiList = new ArrayList<>();
        mockClientiList.add(new BeServiceClienti());
        mockClientiList.add(new BeServiceClienti());
        Page<BeServiceClienti> mockPage = new PageImpl<>(mockClientiList);
        
        when(clientiRepo.findByProvincia("TO", PageRequest.of(0, 10))).thenReturn(mockPage);
        
        ResponseEntity<Page<BeServiceClienti>> response = controller.getClientiByProvinciaSedeLegale("TO", 0, 10);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPage, response.getBody());
    }

    @Test
    //testa l'esistenza sulla sede legale e provincia
    public void testGetClientiByProvinciaSedeLegaleWhenNoClients() {
        Page<BeServiceClienti> mockPage = new PageImpl<>(new ArrayList<>());
        when(clientiRepo.findByProvincia("TO", PageRequest.of(0, 10))).thenReturn(mockPage);

        ResponseEntity<Page<BeServiceClienti>> response = controller.getClientiByProvinciaSedeLegale("TO", 0, 10);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.hasBody());
    }

    @Test
    //testa la get di tutti i clienti
    public void testGetAll_page() {
        List<BeServiceClienti> mockClientiList = new ArrayList<>();
        mockClientiList.add(new BeServiceClienti());
        mockClientiList.add(new BeServiceClienti());
        Page<BeServiceClienti> mockPage = new PageImpl<>(mockClientiList);
        
        when(clientiService.getAll_page(PageRequest.of(0, 10, Sort.by("nomeContatto")))).thenReturn(mockPage);
        
        ResponseEntity<Object> response = controller.getAll_page(PageRequest.of(0, 10));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPage, response.getBody());
    }

    @Test
    //testa la get di tutti i clienti quando non esistono clienti
    public void testGetAll_pageWhenNoClients() {
        Page<BeServiceClienti> mockPage = new PageImpl<>(new ArrayList<>());
        when(clientiService.getAll_page(PageRequest.of(0, 10, Sort.by("nomeContatto")))).thenReturn(mockPage);

        ResponseEntity<Object> response = controller.getAll_page(PageRequest.of(0, 10));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.hasBody());
    }
}
