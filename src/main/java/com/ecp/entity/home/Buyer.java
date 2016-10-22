package com.ecp.entity.home;

import java.io.Serializable;

public class Buyer implements Serializable {

	private static final long serialVersionUID = 3621410694591619688L;

	private Integer id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String company;
	private String address;

	public Buyer() {
	}

	public Buyer(String name, String password, String email, String phone, String company, String address) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name;
	}

}
