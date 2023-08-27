package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Person;
import com.qsp.springboot_hospital.managment.project.repo.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {
		return repo.save(person);

	}

	public Person updatePersonById(int id, Person person) {
		Optional<Person> dbperson = repo.findById(id);
		if (dbperson.isPresent()) {
			person.setId(id);
			return repo.save(person);
		} else {
			return null;
		}
	}

	public Person deletePersonById(int id) {
		Optional<Person> person = repo.findById(id);

		if (person.isEmpty()) {
			return null;
		} else {
			repo.findById(id);
			return person.get();
		}
	}

	public Person findPersonById(int id) {
		Optional<Person> person = repo.findById(id);
		if (person.isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Person> findAllPerson() {
		return repo.findAll();
	}
}