package com.MarketingApp.entity;

import javax.persistence.*;

@Entity
@Table(name="leads")
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name", nullable=false, length=45)
	private String firstName;//in database the column name should be like first_name
	
	@Column(name="last_name", nullable=false, length=45)
	private String lastName;
	
	@Column(name="mobile", nullable=false, length=10,unique=true)
	private long mobile;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="email",nullable=false, length=128, unique=true)
	private String email;

}
