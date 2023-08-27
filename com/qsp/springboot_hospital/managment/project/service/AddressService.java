package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.AddressDao;
import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;

	ResponseStructure<Address> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int id, Address address) {
		Address dbAddress = dao.updateAddress(id, address);
		if (dbAddress != null) {
			address.setId(id);
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id) {
		Address address = dao.deleteAddressById(id);
		if (address != null) {
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {
		Address address = dao.findAddressById(id);
		if (address != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
		List<Address> address = dao.findAllAddress();
		ResponseStructure<List<Address>> structure = new ResponseStructure<>();
		if (address.isEmpty()) {
			return null;

		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.FOUND);
		}
	}
}
