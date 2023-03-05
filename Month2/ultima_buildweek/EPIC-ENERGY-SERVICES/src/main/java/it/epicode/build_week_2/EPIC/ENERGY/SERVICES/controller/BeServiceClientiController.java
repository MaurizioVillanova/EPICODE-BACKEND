package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceClienti;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceClientiRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service.BeServiceClientiService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BeServiceClientiController {

	@Autowired
	BeServiceClientiService cs;

	@Autowired
	BeServiceClientiRepo cr;

	@CrossOrigin
	@GetMapping("/clienti")
	// http://localhost:8080/clienti
	public ResponseEntity<List<BeServiceClienti>> getAll() {
		List<BeServiceClienti> clienti = cs.getAll();

		if (clienti.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(clienti, HttpStatus.OK);
	}

	// --------------------------------FILTRI CLIENTI BY ID

	@GetMapping("/clienti_id/{id}")
	// http://localhost:8080/clienti_id/69
	public ResponseEntity<BeServiceClienti> getCliente(@PathVariable Long id) {
		Optional<BeServiceClienti> clt = cs.getById(id);
		if (clt.isPresent()) {
			return new ResponseEntity<>(clt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cliente/{nome}")
	// http://localhost:8080/cliente/fatima
	public ResponseEntity<List<BeServiceClienti>> GetClientePerNome(@PathVariable String nome) {
		List<BeServiceClienti> clt = cr.findByName(nome);
		if (!clt.isEmpty()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*@GetMapping("/cliente_fatt/{fatt}")
	// http://localhost:8080/cliente_fatt/200000
	public ResponseEntity<List<BeServiceClienti>> trovaPerFatturato(@PathVariable double fatt) {
		List<BeServiceClienti> clt = cr.findByFatturato(fatt);
		if (!clt.isEmpty()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/

	// ---------------------------------METODI PER ORDINARE e FILTRARE PAGABLE CLIENTI------------------------
	
	@GetMapping("/clienti_provincia-sede-legale/{provincia}")
	// http://localhost:8080/clienti_provincia-sede-legale/TO
	public ResponseEntity<Page<BeServiceClienti>> getClientiByProvinciaSedeLegale(@PathVariable String provincia,
	        @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<BeServiceClienti> clienti = cr.findByProvincia(provincia, pageable);
	    if (clienti.hasContent()) {
	        return new ResponseEntity<>(clienti, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	// FILTRO E PAGINATION CON NOME PARZIALE
	// http://localhost:8080/cliente_parziale/ro?page=0&size=3
	@GetMapping("/cliente_parziale/{nome}")
	public ResponseEntity<Page<BeServiceClienti>> trovaPerNomeParziale(@PathVariable String nome, Pageable pageable) {
		Page<BeServiceClienti> clt = cr.findByNameContaining(nome, pageable);
		if (clt.hasContent()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// FILTRO E PAGINATION in base al FATTURATO ANNUALE
	// http://localhost:8080/clienti_fatturato/200000?page=0&size=10
	@GetMapping("/clienti_fatturato/{fatturato}")
	public ResponseEntity<Page<BeServiceClienti>> trovaPerFatturatoMaggioreDi(@PathVariable Double fatturato,
			Pageable pageable) {
		Page<BeServiceClienti> clt = cr.findByFatturatoMaggioreDi(fatturato, pageable);
		if (clt.hasContent()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// ---------------------------------METODI PER ORDINARE PAGABLE CLIENTI------------------------



	// ---------------------------------PAGINATION NOME
	// http://localhost:8080/clienti_page/nome?page=5&size=10
	//--prima pagina 0

	@GetMapping("/clienti_page/nome")
	public ResponseEntity<Object> getAll_page(Pageable pageable) {
		Sort sort = Sort.by("nomeContatto").ascending();
		Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		Page<BeServiceClienti> utenti = cs.getAll_page(sortedPageable);

		if (utenti.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(utenti, HttpStatus.OK);
	}

	// ---------------------------------PAGINATION FATTURATO ANNUALE
	// http://localhost:8080/clienti_page/fatturato?page=0&size=10
	@GetMapping("/clienti_page/fatturato")
	public ResponseEntity<Object> getAll_page_fatturato(Pageable pageable) {
		Sort sort = Sort.by("fatturatoAnnuale").ascending();
		Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		Page<BeServiceClienti> utenti = cs.getAll_page(sortedPageable);

		if (utenti.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(utenti, HttpStatus.OK);
	}

	
	// ---------------------------------------------FILTRO E PAGINAZIONE DATA ULTIMO CONTATTO---------------------------------------------------------------------
	// URL
	// http://localhost:8080/clienti_dataContattoAfter?startDate=2020-01-01?page=0&size=10
	@GetMapping("/clienti_dataContattoAfter")
	@ResponseBody
	public ResponseEntity<Page<BeServiceClienti>> getClientiByDataUltimoContattoAfter(
			@RequestParam("startDate") String startDateStr, Pageable pageable) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(startDateStr);
		Timestamp startTimestamp = new Timestamp(startDate.getTime());
		Page<BeServiceClienti> clt = cr.findByDataUltimoContatto(startTimestamp, pageable);
		if (clt.hasContent()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// URL
	// http://localhost:8080/clienti_byDataUltimoContattoBetween?startDate=2021-01-01&endDate=2022-01-01?page=0&size=10
	@GetMapping("/clienti_byDataUltimoContattoBetween")
	public ResponseEntity<Page<BeServiceClienti>> getClientiByDataUltimoContattoBetween(
			@RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr,
			Pageable pageable) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(startDateStr);
		Date endDate = format.parse(endDateStr);
		Timestamp startTimestamp = new Timestamp(startDate.getTime());
		Timestamp endTimestamp = new Timestamp(endDate.getTime());
		Page<BeServiceClienti> clt = cr.findByDataUltimoContattoBetween(startTimestamp, endTimestamp, pageable);
		if (clt.hasContent()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// URL
	// http://localhost:8080/clienti_dataUltimoContattoBefore?startDate=2022-01-01?page=0&size=10
	@GetMapping("/clienti_dataUltimoContattoBefore")
	public ResponseEntity<Page<BeServiceClienti>> getClientiByDataUltimoContattoBefore(
			@RequestParam("startDate") String startDateStr, Pageable pageable) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(startDateStr);
		Timestamp startTimestamp = new Timestamp(startDate.getTime());
		Page<BeServiceClienti> clt = cr.findByDataUltimoContattoBefore(startTimestamp, pageable);
		if (clt.hasContent()) {
			return new ResponseEntity<>(clt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//FILTRO E PAGINAZIONE DATA INSERITA FINO AD OGGI
		//URL
		//http://localhost:8080/clienti_datainserimentoAfter?startDate=2020-01-01?page=0&size=10
		@GetMapping("/clienti_datainserimentoAfter")
		@ResponseBody
	    public ResponseEntity<Page<BeServiceClienti>> getClientiByDataInserimentoAfter(@RequestParam("startDate") String startDateStr, Pageable pageable) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = format.parse(startDateStr);
	        Timestamp startTimestamp = new Timestamp(startDate.getTime());
	        Page<BeServiceClienti> clt = cr.findByDataInserimentoAfter1(startTimestamp, pageable);
	        if(clt.hasContent()) {
		        return new ResponseEntity<>(clt, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	    }
		//FILTRO E PAGINAZIONE TRA DUE DATE SPECIFICHE
		//URL
		//http://localhost:8080/clienti_byDataInserimentoBetween?startDate=2020-01-01&endDate=2021-01-01?page=0&size=10
		@GetMapping("/clienti_byDataInserimentoBetween")
		@ResponseBody
	    public ResponseEntity<Page<BeServiceClienti>> getClientiByDataInserimentoBetween(@RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr, Pageable pageable) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = format.parse(startDateStr);
	        Date endDate = format.parse(endDateStr);
	        Timestamp startTimestamp = new Timestamp(startDate.getTime());
	        Timestamp endTimestamp = new Timestamp(endDate.getTime());
	        Page<BeServiceClienti> clt = cr.findByDataInserimentoBetween(startTimestamp, endTimestamp,pageable);
	        if(clt.hasContent()) {
		        return new ResponseEntity<>(clt, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	    }
		//FILTRO E PAGINAZIONE DI UNA DATA PRECEDENTE 
		//URL
		//http://localhost:8080/clienti_datainserimentoBefore?startDate=2020-01-01?page=0&size=10
			@GetMapping("/clienti_datainserimentoBefore")
		    public ResponseEntity<Page<BeServiceClienti>> getClientiByDataInserimentoBefore(@RequestParam("startDate") String startDateStr, Pageable pageable) throws ParseException {
		        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        Date startDate = format.parse(startDateStr);
		        Timestamp startTimestamp = new Timestamp(startDate.getTime());
		        Page<BeServiceClienti> clt = cr.findByDataInserimentoBefore(startTimestamp,pageable);
		        if(clt.hasContent()) {
			        return new ResponseEntity<>(clt, HttpStatus.OK);
			    } else {
			        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
		    }

	// MANCA PROVINCIA SEDE LEGALE

	// -------------------------POST MAPPING------------------

	// localhost:8080/aggiungi/cliente

	@CrossOrigin
	@PostMapping("/aggiungi/cliente")
	public ResponseEntity<Object> create(@RequestBody BeServiceClienti d) {
		BeServiceClienti cli = cs.save(d);

		return new ResponseEntity<>(cli, HttpStatus.CREATED);
	}

	// --------------CHECK EXIST METHOD
	private ResponseEntity<Object> checkExists(Optional<BeServiceClienti> obj) {
		if (!obj.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return null;
	}
	// ----------DELETE MAPPING--------------------------------

	// localhost:8080/elimina/cliente/69

	@DeleteMapping("elimina/cliente/{id}")
	public ResponseEntity<Object> eliminaCliente(@PathVariable Long id) {
		Optional<BeServiceClienti> cli = cs.getById(id);
		ResponseEntity<Object> check = checkExists(cli);
		if (check != null)
			return check;

		cs.delete(cli.get());
		return new ResponseEntity<>(String.format("Cliente con id %d eliminato!", id), HttpStatus.OK);
	}

	// ------------PUT MAPPING
	// localhost:8080/modifica/cliente/69

	@PutMapping("modifica/cliente/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody BeServiceClienti _cli) {

		Optional<BeServiceClienti> cliObj = cs.getById(id);

		ResponseEntity<Object> check = checkExists(cliObj);
		if (check != null)
			return check;

		BeServiceClienti cli = cliObj.get();
		cli.setBeServiceIndirizzi1(_cli.getBeServiceIndirizzi1());
		cli.setBeServiceIndirizzi2(_cli.getBeServiceIndirizzi2());
		cli.setCognomeContatto(_cli.getCognomeContatto());
		cli.setDataInserimento(_cli.getDataInserimento());
		cli.setDataUltimoContatto(_cli.getDataUltimoContatto());
		cli.setEmail(_cli.getEmail());
		cli.setEmailContatto(_cli.getEmailContatto());
		cli.setFatturatoAnnuale(_cli.getFatturatoAnnuale());
		cli.setNomeContatto(_cli.getNomeContatto());
		cli.setPartitaIva(_cli.getPartitaIva());
		cli.setPec(_cli.getPec());
		cli.setRagioneSociale(_cli.getRagioneSociale());
		cli.setTelefono(_cli.getTelefono());
		cli.setTelefonoContatto(_cli.getTelefonoContatto());
		cli.setTipoCliente(_cli.getTipoCliente());

		cs.save(cli);

		return new ResponseEntity<>(cli, HttpStatus.CREATED);
	}

}
