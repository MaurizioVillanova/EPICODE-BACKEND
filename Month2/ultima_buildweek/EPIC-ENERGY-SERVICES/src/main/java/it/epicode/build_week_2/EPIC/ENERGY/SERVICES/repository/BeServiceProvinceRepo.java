package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceProvince;

@Repository
public interface BeServiceProvinceRepo extends JpaRepository<BeServiceProvince, Long>{

}
