package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceIndirizzi;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service.BeServiceIndirizziService;

@Controller
public class BeServiceIndirizziController {

	@Autowired
	BeServiceIndirizziService is;
	
	@GetMapping("/indirizzi")
	//http://localhost:8080/indirizzi
	//http://localhost:8080/indirizzi?page=12&size=5
	public ResponseEntity<Page<BeServiceIndirizzi>> gatAll(@RequestParam(defaultValue = "0") int page,
	                                                        @RequestParam(defaultValue = "10") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<BeServiceIndirizzi> ind = is.getAll_page(pageable);
	    if (ind.hasContent()) {
	        return new ResponseEntity<>(ind, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}