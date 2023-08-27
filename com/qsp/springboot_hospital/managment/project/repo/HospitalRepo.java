package com.qsp.springboot_hospital.managment.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.managment.project.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

}
