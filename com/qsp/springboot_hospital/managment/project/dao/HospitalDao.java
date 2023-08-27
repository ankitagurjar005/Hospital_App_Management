package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.repo.HospitalRepo;
@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Optional<Hospital> dbHospital = repo.findById(id);
		if (dbHospital.isPresent()) {
			hospital.setId(id);
			return repo.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital findHospitalById(int id) {
		Optional<Hospital> hospital = repo.findById(id);
		if (hospital.isPresent()) {
			repo.findById(id);
			return hospital.get();
		} else {
			return null;
		}
	}
	
	public List<Hospital> findAll() {
		return repo.findAll();
	}

	public Hospital deleteHospitalById(int id) {
		Optional<Hospital> hospital = repo.findById(id);
		if (hospital.isPresent()) {
			repo.deleteById(id);
			return hospital.get();
		} else {
			return null;
		}
	}

}
