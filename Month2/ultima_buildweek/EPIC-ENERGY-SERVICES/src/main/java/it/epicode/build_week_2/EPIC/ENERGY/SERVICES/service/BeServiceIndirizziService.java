package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceIndirizzi;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceIndirizziRepo;

@Service
public class BeServiceIndirizziService {

	@Autowired
	BeServiceIndirizziRepo ir;
	
	public BeServiceIndirizzi save(BeServiceIndirizzi x) {
		return ir.save(x);
	}
	
	public List<BeServiceIndirizzi> getAll() {
		return ir.findAll();
	}
	
	public Optional<BeServiceIndirizzi> getById(Long id){
		return ir.findById(id);
	}
	
	public void delete(BeServiceIndirizzi c) {
		ir.delete(c);
	}
	
	public Page<BeServiceIndirizzi> getAll_page(Pageable pageable) {
		return ir.findAll(pageable);
	}
}
