package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.HospitalDao;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	ResponseStructure<Hospital> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int id, Hospital hospital) {
		Hospital dbHospital = dao.updateHospital(id, hospital);
		if (dbHospital != null) {
			hospital.setId(id);
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbHospital);
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int id) {
		Hospital hospital = dao.deleteHospitalById(id);
		if (hospital != null) {
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id) {
		Hospital hospital = dao.findHospitalById(id);
		if (hospital != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospital() {
		List<Hospital> hospital = dao.findAll();
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<>();
		if (hospital.isEmpty()) {
			throw new EmptyDataNotFoundException("data is not prsent");

		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<List<Hospital>>>(structure, HttpStatus.FOUND);
		}
	}
}
