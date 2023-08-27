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

import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.service.EncounterService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	@Autowired
	private EncounterService service;

	@ApiOperation(value = "Save Encounter", notes = "This API is used to  save the Encounter data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,
			@RequestParam int p_id, @RequestParam int b_id) {
		return service.saveEncounter(encounter, p_id, b_id);
	}

	@ApiOperation(value = "Update Encounter", notes = "This API is used to  Update the Encounter data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(@Valid @RequestParam int id,
			@RequestBody Encounter encounter, @RequestParam int b_id) {
		return service.updateEncounterById(id, encounter, b_id);
	}

	@ApiOperation(value = "Deleted Encounter", notes = "This API is used to  deleted the Encounter data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(@Valid @PathVariable int id) {
		return service.deleteEncounterById(id);
	}

	@ApiOperation(value = "Fetch Encounter", notes = "This API is used to  fetch the Encounter data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(@Valid @RequestParam int id) {
		return service.findEncounterById(id);
	}

	@ApiOperation(value = "Fetch All Encounter", notes = "This API is used to  fetchAll the Encounter data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllEncounter")
	public ResponseEntity<ResponseStructure<List<Encounter>>> findAllEncounter() {
		return service.findAllEncounter();
	}

}