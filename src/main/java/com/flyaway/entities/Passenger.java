package com.flyaway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="passengers")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pnr")
	int pnr;
	
	@Column(name="govId")
	String govId;
	
	@Column(name="firstname")
	String firstname;
	
	@Column(name="lastname")
	String lastname;
	
	@Column(name="age")
	int age;
	
	@Column(name="ph")
	String ph;

	public Passenger(String firstname, String lastname, int age,
			String govId, String ph) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.govId = govId;
		this.ph = ph;
	}
	
	public Passenger() {
		super();
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getPNR() {
		return age;
	}

	public void setPNR(int age) {
		this.age = age;
	}

	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	

}
