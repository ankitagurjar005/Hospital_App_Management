package com.qsp.springboot_hospital.managment.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.managment.project.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {

}
