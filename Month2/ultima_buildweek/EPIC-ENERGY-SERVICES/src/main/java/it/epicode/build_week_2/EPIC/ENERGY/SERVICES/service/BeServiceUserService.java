package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceUserRepo;

@Service
public class BeServiceUserService {

	@Autowired
	BeServiceUserRepo ur;
}
