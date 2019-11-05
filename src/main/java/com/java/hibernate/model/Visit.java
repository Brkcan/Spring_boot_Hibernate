package com.java.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "t_visit")
public class Visit extends BaseEntity {

	@Lob
	@Column(name = "visit_desc")
	private String visitDesc;
	
	@Column(name = "visit_date")
	private Date visitDate;

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

}
