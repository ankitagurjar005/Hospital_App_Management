package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Encounter;
import com.qsp.springboot_hospital.managment.project.dto.MedOrder;
import com.qsp.springboot_hospital.managment.project.repo.MedOrderRepo;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepo repo;

	@Autowired
	private EncounterDao dao;

	public MedOrder saveMedOrder(MedOrder medOrder, int e_id) {
		Encounter encounter = dao.findEncounterById(e_id);
		medOrder.setEncounter(encounter);
		return repo.save(medOrder);
	}

	public MedOrder updateMedOrderById(int id, MedOrder medOrder) {
		Optional<MedOrder> dbmedOrder = repo.findById(id);
		if (dbmedOrder.isPresent()) {
			medOrder.setId(id);
			return repo.save(medOrder);
		} else {
			return null;
		}
	}

	public MedOrder deleteMedOrderById(int id) {
		Optional<MedOrder> dbmedOrder = repo.findById(id);
		if (dbmedOrder.isPresent()) {
			MedOrder medOrder = repo.findById(id).get();
			repo.deleteById(id);
			return medOrder;
		} else {
			return null;
		}
	}

	public MedOrder findMedOrderById(int id) {
		Optional<MedOrder> dbmedOrder = repo.findById(id);
		if (dbmedOrder.isPresent()) {
			MedOrder medOrder = repo.findById(id).get();
			return medOrder;
		} else {
			return null;
		}
	}

	public List<MedOrder> findAll() {
		return repo.findAll();
	}

}
