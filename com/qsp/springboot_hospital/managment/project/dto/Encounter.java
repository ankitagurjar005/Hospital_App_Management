package com.qsp.springboot_hospital.managment.project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "reason can't be null")
	@NotBlank(message = "reason can't be blank")
	private String reason;
	@Min(value = 1)
	private long cost;

	@ManyToOne
	private Person person;
	@OneToMany
	private List<Branches> branches;
}
