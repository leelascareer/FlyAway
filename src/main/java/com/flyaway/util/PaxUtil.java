package com.flyaway.util;

public class PaxUtil {
	
	int pnr;
	String firstname;
	String lastname;
	int age;
	String govId;
	String ph;
	
	public PaxUtil() {
	}
	
	public PaxUtil(int paxid, String firstname, String lastname, int age,
			String govId, String ph) {
		this.pnr = paxid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.govId = govId;
		this.ph = ph;
	}

	public int getPNR() {
		return pnr;
	}

	public void setPNR(int paxid) {
		this.pnr = paxid;
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
