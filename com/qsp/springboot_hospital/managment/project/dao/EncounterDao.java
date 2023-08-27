package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo repo;

	public Encounter saveEncounter(Encounter encounter) {
		return repo.save(encounter);
	}

	public Encounter updateEncounterById(int id, Encounter encounter,int b_id) {
		Optional<Encounter> dbEncounter = repo.findById(id);
		if (dbEncounter.isPresent()) {
			encounter.setId(id);
			return repo.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter deleteEncounterById(int id) {
		Optional<Encounter> dbEncounter = repo.findById(id);
		if (dbEncounter.isPresent()) {
			repo.deleteById(id);
			return dbEncounter.get();
		} else {
			return null;
		}
	}

	public Encounter findEncounterById(int id) {
		Optional<Encounter> encounter = repo.findById(id);
		if (encounter.isPresent()) {
			repo.findById(id);
			return encounter.get();
		} else {
			return null;
		}
	}

	public List<Encounter> findAllEncounter() {
		return repo.findAll();
	}

}