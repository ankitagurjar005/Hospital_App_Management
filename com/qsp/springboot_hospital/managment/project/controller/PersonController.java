package com.qsp.springboot_hospital.managment.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.managment.project.dto.Person;
import com.qsp.springboot_hospital.managment.project.service.PersonService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.val;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService service;

	@ApiOperation(value = "Save Person", notes = "This API is used to  save the person data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "Update Person", notes = "This API is used to  update the person data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated Successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePersonById(@Valid @RequestParam int id,
			@RequestBody Person person) {
		return service.updatePersonById(id, person);
	}

	@ApiOperation(value = "Deleted Person", notes = "This API is used to  delete the Person data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePersonById(@Valid @PathVariable int id) {
		return service.deletePersonById(id);
	}

	@ApiOperation(value = "Fetch Person", notes = "This API is used to  Fetch the person data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> findPersonById(@Valid @RequestParam int id) {
		return service.findPersonById(id);
	}

	@ApiOperation(value = "Fetch All Person", notes = "This API is used to  fetchAll the person data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllPerson")
	public ResponseEntity<ResponseStructure<Person>> findAllPerson() {
		return service.findAllPerson();
	}
}