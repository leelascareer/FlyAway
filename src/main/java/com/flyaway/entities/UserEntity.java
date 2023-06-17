package com.flyaway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Column(name="userid")
	@Id
	@GeneratedValue
	int userid;

	@Column(name="username")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String username;
	
	@Column(name="password")
	String password;

	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserEntity() {
		super();
	}

	public int getId() {
		return userid;
	}

	public void setId(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
