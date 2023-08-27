package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.PersonDao;
import com.qsp.springboot_hospital.managment.project.dto.Person;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person> structure = new com.qsp.springboot_hospital.managment.project.util.ResponseStructure();

	public ResponseEntity<com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person>> savePerson(
			Person person) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		return new ResponseEntity(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person>> updatePersonById(
			int id, Person person) {
		Person dbPerson = dao.findPersonById(id);
		if (dbPerson != null) {
			person.setId(id);
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.savePerson(person));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not prsent");
		}

	}

	public ResponseEntity<com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person>> deletePersonById(
			int id) {
		Person dbPerson = dao.findPersonById(id);
		if (dbPerson != null) {
			structure.setMessage("deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletePersonById(id));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person>> findPersonById(
			int id) {
		Person dbPerson = dao.findPersonById(id);
		if (dbPerson != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findPersonById(id));
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<com.qsp.springboot_hospital.managment.project.util.ResponseStructure<Person>> findAllPerson() {
		List<Person> dbPerson = dao.findAllPerson();
		com.qsp.springboot_hospital.managment.project.util.ResponseStructure<List<Person>> structure = new com.qsp.springboot_hospital.managment.project.util.ResponseStructure();
		if (dbPerson.isEmpty()) {
			throw new EmptyDataNotFoundException("data is not prsent");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbPerson);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
	}

}
