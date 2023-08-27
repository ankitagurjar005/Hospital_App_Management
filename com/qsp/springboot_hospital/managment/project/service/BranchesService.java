package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.springboot_hospital.managment.project.dao.BranchDao;
import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class BranchesService {
	@Autowired
	private BranchDao dao;

	ResponseStructure<Branches> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Branches>> saveBranches(Branches branches, int h_id, int a_id) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveBranches(branches, h_id, a_id));
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branches>> updateBranchById(int id, Branches branches) {
		Branches dbBranches = dao.updateBranchesById(id, branches);
		if (dbBranches != null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbBranches);
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Branches>> deleteBranchById(int id) {
		Branches branches = dao.deleteBranchById(id);
		if (branches != null) {
			structure.setMessage("Delted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branches);
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<Branches>> findBranchById(int id) {
		Branches branches = dao.findBranchById(id);
		if (branches != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branches);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<List<Branches>>> findAllBranches() {
		List<Branches> branches = dao.findAllBranches();
		ResponseStructure<List<Branches>> structure = new ResponseStructure<>();
		if (branches.isEmpty()) {
			throw new EmptyDataNotFoundException("data not found");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branches);
			return new ResponseEntity<ResponseStructure<List<Branches>>>(structure, HttpStatus.FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Branches>>> findBranchHospitalById(int h_id) {
		List<Branches> branches = dao.findBranchByHospitalId(h_id);
		ResponseStructure<List<Branches>> structure = new ResponseStructure<>();
		if (branches.isEmpty()) {
			throw new IdNotFoundException("id is not present");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branches);
			return new ResponseEntity<ResponseStructure<List<Branches>>>(structure, HttpStatus.FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Branches>>> findBranchAddressById(int a_id) {
		List<Branches> branches = dao.findBranchByAddressId(a_id);
		ResponseStructure<List<Branches>> structure = new ResponseStructure<>();
		if (branches.isEmpty()) {
			throw new IdNotFoundException("id is not present");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branches);
			return new ResponseEntity<ResponseStructure<List<Branches>>>(structure, HttpStatus.FOUND);
		}
	}

}