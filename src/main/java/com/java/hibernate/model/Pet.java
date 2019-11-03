package com.java.hibernate.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity {

	@Basic // (optional = true)
	@Column(name = "pet_name") // nullable = false)
	private String name;

	@Column(name = "birth_date")
	private Date birthDate;

	public Pet() {
	}

	public Pet(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
