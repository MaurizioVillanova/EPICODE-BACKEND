package it.epicode.build_week_2.EPIC.ENERGY.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service.BeServiceComuniservice;

@SpringBootApplication
public class EpicEnergyServicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EpicEnergyServicesApplication.class, args);
	}

	@Autowired
	BeServiceComuniservice cR;
	boolean crea = false;
	boolean creaprovince = false;

	@Override
	public void run(String... args) throws Exception {
		if (crea) cR.saveComuni(); 
		if (creaprovince) cR.saveProvince();
	}
}
