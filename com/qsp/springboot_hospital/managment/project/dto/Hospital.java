package com.qsp.springboot_hospital.managment.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	private String name;
	@Column(unique = true)
	@NotNull(message = "email can't be null")
	@NotBlank(message = "email can't be blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z][in,com]{2,3}", message = "Invalid Email")
	private String email;
	@NotNull(message = "gst can't be null")
	@NotBlank(message = "gst can't be blank")
	private String gst;
}
