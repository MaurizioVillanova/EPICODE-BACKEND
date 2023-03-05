package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceFatture;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceFattureRepo;
import org.springframework.data.domain.Pageable;

@Service
public class BeServiceFattureService {

	@Autowired
	BeServiceFattureRepo fatturerepo;
	
	public BeServiceFatture save(BeServiceFatture x) {
		return fatturerepo.save(x);
	}
	
	public List<BeServiceFatture> getAll() {
		return fatturerepo.findAll();
	}
	
	public Optional<BeServiceFatture> getById(Long id){
		return fatturerepo.findById(id);
	}
	
	public void delete(BeServiceFatture c) {
		fatturerepo.delete(c);
	}
	
	public Page<BeServiceFatture> getAll_page(Pageable pageable) {
		return fatturerepo.findAll(pageable);
	}
	
}


