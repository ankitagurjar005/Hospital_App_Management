package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;
import com.qsp.springboot_hospital.managment.project.repo.BranchesRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchesRepo repo;

	@Autowired
	private HospitalDao hospitalDao;

	@Autowired
	private AddressDao addressDao;

	public Branches saveBranches(Branches branches, int h_id, int a_id) {
		Hospital hospital = hospitalDao.findHospitalById(h_id);
		branches.setHospital(hospital);

		Address address = addressDao.findAddressById(a_id);
		branches.setAddress(address);

		return repo.save(branches);
	}

	public Branches updateBranchesById(int id, Branches branches) {
		Branches dbBranches = repo.findById(id).get();
		if (dbBranches != null) {
			branches.setId(id);
			branches.setHospital(dbBranches.getHospital());
			branches.setAddress(dbBranches.getAddress());
			return repo.save(branches);
		} else {
			return null;
		}
	}

	public Branches deleteBranchById(int id) {
		Optional<Branches> branches = repo.findById(id);
		if (branches.isPresent()) {
			Branches dbbranches = repo.findById(id).get();
			repo.deleteById(id);
			return dbbranches;
		} else {
			return null;
		}
	}

	public Branches findBranchById(int id) {
		Optional<Branches> branches = repo.findById(id);
		if (branches.isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Branches> findAllBranches() {
		return repo.findAll();
	}

	public List<Branches> findBranchByHospitalId(int h_id) {
		Hospital hospital = hospitalDao.findHospitalById(h_id);
		if (hospital != null) {
			return repo.findBranchByHospitalId(hospital);
		} else {
			return null;
		}
	}

	public List<Branches> findBranchByAddressId(int a_id) {
		Address address = addressDao.findAddressById(a_id);
		if (address != null) {
			return repo.findBranchByAddressId(address);
		} else {
			return null;
		}
	}

}
