package com.java.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity {

	@Basic // (optional = true)
	@Column(name = "pet_name") // nullable = false)
	private String name;

	@Column(name = "birth_date")
	private Date birthDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@OneToMany
	@JoinColumn(name = "pet_id")
	@OrderColumn(name = "visit_order")
	private List<Visit> visits = new ArrayList<Visit>();

	@OneToMany
	@MapKey(name="filePath")
	@JoinColumn(name = "pet_id")
	private Map<String, Image> imagesByFilePath = new HashMap<String, Image>();
	
	public Pet() {
	}

	public Pet(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
