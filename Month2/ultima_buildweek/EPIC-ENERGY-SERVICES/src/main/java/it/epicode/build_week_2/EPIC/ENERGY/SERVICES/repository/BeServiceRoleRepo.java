package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceRole;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.RoleType;

@Repository
public interface BeServiceRoleRepo extends JpaRepository<BeServiceRole, Long>{

	BeServiceRole findByRoleName(RoleType roleUser);
}
