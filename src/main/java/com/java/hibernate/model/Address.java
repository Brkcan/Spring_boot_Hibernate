package com.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Address {

	@Column(table="t_address", name = "phone_type")
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;

	@Column(table = "t_address")
	private String street;

	@Column(table = "t_address")
	private String phone;

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", phone=" + phone + "]";
	}

}
