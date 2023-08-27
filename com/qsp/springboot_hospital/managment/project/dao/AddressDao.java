package com.qsp.springboot_hospital.managment.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.managment.project.dto.Address;
import com.qsp.springboot_hospital.managment.project.repo.AddressRepo;
@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address updateAddress(int id, Address address) {
		Optional<Address> dbAddress = repo.findById(id);
		if (dbAddress != null) {
			address.setId(id);
			return repo.save(address);
		} else {
			return null;
		}
	}

	public Address findAddressById(int id) {
		Optional<Address> address = repo.findById(id);
		if (address != null) {
			repo.findById(id);
			return address.get();
		} else {
			return null;
		}
	}

	public List<Address> findAllAddress() {
		return repo.findAll();
	}

	public Address deleteAddressById(int id) {
		Optional<Address> address = repo.findById(id);
		if (address != null) {
			repo.deleteById(id);

			return address.get();
		} else {
			return null;
		}
	}
}
