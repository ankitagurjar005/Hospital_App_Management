package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.MedOrderDao;
import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao dao;
	ResponseStructure<MedOrder> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int e_id) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedOrder(medOrder, e_id));
		return new ResponseEntity(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedoOrderById(int id, MedOrder medOrder) {
		MedOrder dbMedOrder = dao.findMedOrderById(id);
		if (dbMedOrder != null) {
			medOrder.setEncounter(dbMedOrder.getEncounter());
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedOrderById(id, medOrder));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrderById(int id) {
		MedOrder medOrder = dao.findMedOrderById(id);
		if (medOrder != null) {
			structure.setMessage("deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteMedOrderById(id));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrderById(int id) {
		MedOrder medOrder = dao.findMedOrderById(id);
		if (medOrder != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrder() {

		List<MedOrder> medOrder = dao.findAll();
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<>();
		if (medOrder.isEmpty()) {
			throw new EmptyDataNotFoundException("data is not prsent");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(structure, HttpStatus.FOUND);
		}

	}
}