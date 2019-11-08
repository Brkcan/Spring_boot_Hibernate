package com.java.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@Entity
@Table(name = "t_owner")
public class Owner extends Person {

	@Column(table = "t_owner", name = "t_rating")
	@Convert(converter = RatingAttributeConverter.class)
	// @Enumerated(EnumType.ORDINAL)
	private Rating rating;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
