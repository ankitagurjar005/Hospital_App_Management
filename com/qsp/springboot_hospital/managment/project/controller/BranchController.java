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

import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.service.BranchesService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchesService service;

	@ApiOperation(value = "Save Branches", notes = "This API is used to  save the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Branches>> saveEncounter(@Valid @RequestBody Branches branches,
			@RequestParam int h_id, @RequestParam int a_id) {
		return service.saveBranches(branches, h_id, a_id);
	}

	@ApiOperation(value = "Update Branches", notes = "This API is used to  update the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Branches>> updateBranchesById(@Valid @RequestParam int id,
			@RequestBody Branches branches) {
		return service.updateBranchById(id, branches);
	}

	@ApiOperation(value = "Deleted Branches", notes = "This API is used to  delete the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Branches>> deleteBranchesById(@Valid @PathVariable int id) {
		return service.deleteBranchById(id);
	}

	@ApiOperation(value = "Fetch Branches", notes = "This API is used to  fetch the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Branches>> findBranchesById(@Valid @RequestParam int id) {
		return service.findBranchById(id);
	}

	@ApiOperation(value = "Fetch All Branches", notes = "This API is used to  fetchAll the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllBranches")
	public ResponseEntity<ResponseStructure<List<Branches>>> findAllEncounter() {
		return service.findAllBranches();
	}

	@ApiOperation(value = "fetchHospitalIdBy MedItems", notes = "This API is used to  fetchHospitalIdBy the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping("/findHosptalById")
	public ResponseEntity<ResponseStructure<List<Branches>>> findBranchHopitalById(@Valid @RequestParam int h_id) {
		return service.findBranchHospitalById(h_id);
	}

	@ApiOperation(value = "FetchAddressBy Branches", notes = "This API is used to  fetchAddressIdBy the Branches data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping("/findAddressById")
	public ResponseEntity<ResponseStructure<List<Branches>>> findBranchAddressById(@Valid @RequestParam int a_id) {
		return service.findBranchAddressById(a_id);
	}

}
