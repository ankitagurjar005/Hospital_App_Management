package com.qsp.springboot_hospital.managment.project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "city can't be null")
	@NotBlank(message = "city can't be blank")
	private String city;
	@NotNull(message = "state can't be null")
	@NotBlank(message = "state can't be blank")
	private String state;
	@NotNull(message = "pin can't be null")
	@NotBlank(message = "pin can't be blank")
	@Min(value = 1)
	private int pin;

}
