package com.java.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_clinic")
public class Clinic extends BaseEntity{

	@Column(name = "t_name")
	private String name;
	
	@OneToMany
	@JoinTable(name = "t_clinic_owner", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="owner_id"))
	private Set<Owner> owners = new HashSet<Owner>();
 
	@OneToMany
	@JoinTable(name = "t_clinic_vet", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="vet_id"))
	private Set<Vet> vets = new HashSet<Vet>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
