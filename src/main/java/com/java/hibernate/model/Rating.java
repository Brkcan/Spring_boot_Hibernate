package com.java.hibernate.model;

public enum Rating {
	STANDANRT(100),PREMIUM(200);
	
	private int value;
	
	private Rating(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
}
