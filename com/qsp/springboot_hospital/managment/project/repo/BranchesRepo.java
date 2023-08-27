package com.qsp.springboot_hospital.managment.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.dto.Branches;
import com.qsp.springboot_hospital.managment.project.dto.Hospital;

public interface BranchesRepo extends JpaRepository<Branches, Integer> {

	List<Branches> findBranchByHospitalId(Hospital hospital);

	List<Branches> findBranchByAddressId(Address address);

}
