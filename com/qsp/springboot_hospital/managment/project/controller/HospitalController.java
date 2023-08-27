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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.service.HospitalService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "Save Hospital", notes = "This API is used to  save the Hospital data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@ApiOperation(value = "Update Hospital", notes = "This API is used to  update the Hospital data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated Successfully") })
	@PutMapping("/updateHospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@Valid @RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospitalById(id, hospital);
	}

	@ApiOperation(value = "Deleted Hospital", notes = "This API is used to  delete the Hospital data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/deleteHospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@Valid @PathVariable int id) {
		return service.deleteHospitalById(id);
	}

	@ApiOperation(value = "Fetch Hospital", notes = "This API is used to  Fetch the Hospital data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping("/findHospital")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(@Valid @RequestParam int id) {
		return service.findHospitalById(id);
	}

	@ApiOperation(value = "Fetch All Hospital", notes = "This API is used to  fetchAll the Hospital data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllHospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospital() {
		return service.findAllHospital();
	}
}
