package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceClienti;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceClientiRepo;

@Service
public class BeServiceClientiService {
	
	@Autowired
	BeServiceClientiRepo clientirepo;
	
	public BeServiceClienti save(BeServiceClienti x) {
		return clientirepo.save(x);
	}
	
	public List<BeServiceClienti> getAll() {
		return clientirepo.findAll();
	}
	
	public Optional<BeServiceClienti> getById(Long id){
		return clientirepo.findById(id);
	}
	
	public Page<BeServiceClienti> getAll_page(Pageable pageable) {
		return clientirepo.findAll(pageable);
	}
	
	public void delete(BeServiceClienti c) {
		clientirepo.delete(c);
	}
	
	
	
	
}

