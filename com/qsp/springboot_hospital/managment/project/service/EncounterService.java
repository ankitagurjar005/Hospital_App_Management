package com.qsp.springboot_hospital.managment.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.BranchDao;
import com.qsp.springboot_hospital.managment.project.dao.EncounterDao;
import com.qsp.springboot_hospital.managment.project.dao.PersonDao;
import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.dto.Person;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	ResponseStructure<Encounter> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int p_id, int b_id) {
		Person person = personDao.findPersonById(p_id);
		Branches branches = branchDao.findBranchById(b_id);

		encounter.setPerson(person);
		List<Branches> dbBranches = new ArrayList();

		dbBranches.add(branches);
		encounter.setBranches(dbBranches);

		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEncounter(encounter));
		return new ResponseEntity(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(int id, Encounter encounter, int b_id) {
		Encounter dbEncounter = dao.findEncounterById(id);

		if (dbEncounter != null) {
			Branches branches = branchDao.findBranchById(id);
			List<Branches> dbBranches = dbEncounter.getBranches();
			encounter.setBranches(dbBranches);
			encounter.setPerson(dbEncounter.getPerson());
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEncounterById(id, encounter, b_id));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(int id) {
		Encounter encounter = dao.deleteEncounterById(id);
		if (encounter != null) {
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(int id) {
		Encounter encounter = dao.findEncounterById(id);
		if (encounter != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<List<Encounter>>> findAllEncounter() {
		List<Encounter> encounter = dao.findAllEncounter();
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<>();
		if (encounter.isEmpty()) {
			throw new EmptyDataNotFoundException("Data not found");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<List<Encounter>>>(structure, HttpStatus.FOUND);
		}
	}
}
