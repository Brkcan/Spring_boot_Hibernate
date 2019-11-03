package com.java.hibernate.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_pet")
public class Pet {

	@Id
	@Column(name = "id",columnDefinition = "int default 1")
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;

	@Basic //(optional = true)
	@Column(name = "pet_name") //nullable = false)
	private String name;

	@Column(name = "birth_date")
	private Date birthDate;

	public Pet() {
	}

	public Pet(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
