package com.java.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pet")
public class Pet {

	@Id
	@Column(name = "id")
	private int id;

	@Basic
	@Column(name = "pet_name")
	private String name;

	public Pet() {
	}

	public Pet(String name) {
		this.name = name;
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
		return "Pet [id=" + id + ", name=" + name + "]";
	}

}
