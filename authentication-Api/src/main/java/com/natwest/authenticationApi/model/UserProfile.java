package com.natwest.authenticationApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Userprofile")
public class UserProfile {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String phoneno;
	private String acnumber;
	private String address;
	
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String username, String name, String address, String acnumber, String phoneno, String password) {
		super();
		this.username = username;
		this.name = name;
		this.address = address;
		this.acnumber = acnumber;
		this.phoneno = phoneno;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserProfile [username=" + username + ", name=" + name + ", address=" + address + ", acnumber="
				+ acnumber + ", phoneno=" + phoneno + ", password=" + password + "]";
	}
	
	

}
