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

import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.service.MedItemsService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {
	@Autowired
	private MedItemsService service;

	@ApiOperation(value = "Save MedItems", notes = "This API is used to  save the MedItems data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "saved Successfully") })
	@PostMapping("/saveMedItems")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@Valid  @RequestBody MedItems medItems,@RequestParam int m_id) {
		return service.saveMedItems(medItems, m_id);
	}

	@ApiOperation(value = "Update MedItems", notes = "This API is used to  update the MedItems data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated Successfully") })
	@PutMapping("/updateMedItems")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItemsById(@Valid @RequestParam int id, @RequestBody MedItems medItems) {
		return service.updateMedItemsById(id, medItems);
	}

	@ApiOperation(value = "Deleted MedItems", notes = "This API is used to  delete the MedItems data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/deleteMedItems/{id}")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemsById(@Valid @PathVariable int id) {
		return service.deleteMedItemsById(id);
	}

	@ApiOperation(value = "Fetch MedItems", notes = "This API is used to  Fetch the MedItems data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found Successfully") })
	@GetMapping("/findMedItems")
	public ResponseEntity<ResponseStructure<MedItems>> findMedItemsById(@Valid @RequestParam int id) {
		return service.findMedItemsById(id);
	}

	@ApiOperation(value = "Fetch All MedItems", notes = "This API is used to  fetchAll the MedItems data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FoundAll Successfully") })
	@GetMapping("/findAllMedItems")
	public ResponseEntity<ResponseStructure<List<MedItems>>> findAllMedItems() {
		return service.findAllMedItems();
	}

}
