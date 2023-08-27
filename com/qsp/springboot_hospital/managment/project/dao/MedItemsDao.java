package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.dto.MedItems;
import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.repo.MedItemsRepo;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepo repo;

	@Autowired
	private MedOrderDao dao;

	public MedItems saveMedItems(MedItems medItems, int m_id) {
		MedOrder medOrder = dao.findMedOrderById(m_id);
		medItems.setMedOrder(medOrder);
		return repo.save(medItems);
	}

	public MedItems updateMedItemsById(int id, MedItems medItems) {
		Optional<MedItems> dbmedItems = repo.findById(id);
		if (dbmedItems.isPresent()) {
			medItems.setId(id);
			return repo.save(medItems);
		} else {
			return null;
		}
	}

	public MedItems deleteMedItemsById(int id) {
		Optional<MedItems> dbMedItems = repo.findById(id);
		if (dbMedItems.isPresent()) {
			MedItems medItems = repo.findById(id).get();
			repo.deleteById(id);
			return medItems;
		} else {
			return null;
		}
	}

	public MedItems findMedItemsById(int id) {
		Optional<MedItems> dbmedItems = repo.findById(id);
		if (dbmedItems.isPresent()) {
			MedItems medItems = repo.findById(id).get();
			return medItems;
		} else {
			return null;
		}
	}

	public List<MedItems> findAll() {
		return repo.findAll();
	}

}
