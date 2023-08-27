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

import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.dto.Person;
import com.qsp.springboot_hospital.managment.project.service.MedOrderService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {
	@Autowired
	private MedOrderService service;

	@ApiOperation(value = "Save MedOrder", notes = "This API is used to  save the medOrder data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping("/saveMed")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMed(@Valid @RequestBody MedOrder medOrder, @RequestParam int e_id) {
		return service.saveMedOrder(medOrder, e_id);
	}

	@ApiOperation(value = "Update MedOrder", notes = "This API is used to  update the MedOrder data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated Successfully") })
	@PutMapping("/updateMedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrderById(@Valid @RequestParam int id,
			@RequestBody MedOrder MedOrder) {
		return service.updateMedoOrderById(id, MedOrder);
	}

	@ApiOperation(value = "Deleted MedOrder", notes = "This API is used to  delete the MedOrder data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/deleteMedOrder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(@Valid @PathVariable int id) {
		return service.deleteMedOrderById(id);
	}

	@ApiOperation(value = "Fetch MedOrder", notes = "This API is used to  Fetch the MedOrder data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping("/findMedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> findPersonById(@Valid @RequestParam int id) {
		return service.findMedOrderById(id);
	}

	@ApiOperation(value = "Fetch All MedOrder", notes = "This API is used to  fetchAll the MedOrder data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllMedOrder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrder() {
		return service.findAllMedOrder();
	}
}
