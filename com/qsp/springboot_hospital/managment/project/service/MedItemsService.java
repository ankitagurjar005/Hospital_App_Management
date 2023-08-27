package com.qsp.springboot_hospital.managment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.managment.project.dao.MedItemsDao;
import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.exception.EmptyDataNotFoundException;
import com.qsp.springboot_hospital.managment.project.exception.IdNotFoundException;
import com.qsp.springboot_hospital.managment.project.util.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao dao;

	ResponseStructure<MedItems> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int m_id) {
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedItems(medItems, m_id));
		return new ResponseEntity(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItemsById(int id, MedItems medItems) {
		MedItems dBMedItems = dao.findMedItemsById(id);
		if (dBMedItems != null) {
			dBMedItems.setMedOrder(dBMedItems.getMedOrder());
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedItemsById(id, medItems));
			return new ResponseEntity(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItemsById(int id) {
		MedItems medItems = dao.findMedItemsById(id);
		if (medItems != null) {
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItems);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> findMedItemsById(int id) {
		MedItems medItems = dao.findMedItemsById(id);
		if (medItems != null) {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItems);
			return new ResponseEntity(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id is not present");
		}

	}

	public ResponseEntity<ResponseStructure<List<MedItems>>> findAllMedItems() {
		List<MedItems> items = dao.findAll();
		ResponseStructure<List<MedItems>> structure = new ResponseStructure<>();
		if (items.isEmpty()) {
			throw new EmptyDataNotFoundException("Data not found");
		} else {
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(items);
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(structure, HttpStatus.FOUND);
		}
	}
}
