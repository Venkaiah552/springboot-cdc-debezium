package com.cdc.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private Integer id;

	private String name;

	private String address;

	private String email;
}
