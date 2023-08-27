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

import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.service.AddressService;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Address")
public class AddressController {

	@Autowired
	private AddressService service;

	@ApiOperation(value = "Save Address", notes = "This API is used to  save the Address data from the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}

	@ApiOperation(value = "Updated Address", notes = "This API is used to  update the Address data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Successfully") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@Valid @RequestParam int id,
			@RequestBody Address address) {
		return service.updateAddressById(id, address);
	}

	@ApiOperation(value = "Deleted Address", notes = "This API is used to  Delted the Address data from the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Successfully") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@Valid @PathVariable int id) {
		return service.deleteAddressById(id);
	}

	@ApiOperation(value = "fetch Address", notes = "This API is used to  fetch the Address data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "fetch Successfully") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@Valid @RequestParam int id) {
		return service.findAddressById(id);
	}

	@ApiOperation(value = "FetchAll Address", notes = "This API is used to  fetchAll the Address data from the database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FetchAll Successfully") })
	@GetMapping("/findAllAddress")
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
		return service.findAllAddress();
	}
}
