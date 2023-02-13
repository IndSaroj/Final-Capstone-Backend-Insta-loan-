package com.natwest.userApi.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Userprofile")
public class UserProfile {
	
	@ApiModelProperty(notes="Username field is my primary key as email-ID")
	@Id
	private String username;
	private String password;
	private String name;
	private String phoneno;
	private String acnumber;
	private String address;
	private String confirmpassword;
	
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String username, String name, String address, String acnumber, String phoneno, String password, String confirmpassword) {
		super();
		this.username = username;
		this.name = name;
		this.address = address;
		this.acnumber = acnumber;
		this.phoneno = phoneno;
		this.password = password;
		this.confirmpassword = confirmpassword;
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

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "UserProfile [username=" + username + ", password=" + password + ", name=" + name + ", phoneno="
				+ phoneno + ", acnumber=" + acnumber + ", address=" + address + ", confirmpassword=" + confirmpassword
				+ "]";
	}

	

}