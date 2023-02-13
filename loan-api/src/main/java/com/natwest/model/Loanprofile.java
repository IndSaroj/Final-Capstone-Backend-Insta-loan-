package com.natwest.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class Loanprofile {
	
	@Id
	private String email;
	private String income;
	private String vehicleprice;
	private String loanamount;
	private int term;
	private int age;
	private String emptype;
	private String pan;
	private String status = "pending";
	public Loanprofile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loanprofile(String email, String income, String vehicleprice, String loanamount, int term, int age,
			String emptype, String pan, String status) {
		super();
		this.email = email;
		this.income = income;
		this.vehicleprice = vehicleprice;
		this.loanamount = loanamount;
		this.term = term;
		this.age = age;
		this.emptype = emptype;
		this.pan = pan;
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getVehicleprice() {
		return vehicleprice;
	}
	public void setVehicleprice(String vehicleprice) {
		this.vehicleprice = vehicleprice;
	}
	public String getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(String loanamount) {
		this.loanamount = loanamount;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmptype() {
		return emptype;
	}
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Loanprofile [email=" + email + ", income=" + income + ", vehicleprice=" + vehicleprice + ", loanamount="
				+ loanamount + ", term=" + term + ", age=" + age + ", emptype=" + emptype + ", pan=" + pan + ", status="
				+ status + "]";
	}
  
	
}