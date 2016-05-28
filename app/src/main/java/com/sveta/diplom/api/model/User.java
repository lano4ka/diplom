package com.sveta.diplom.api.model;

public class User {
	
	private String name;
	
	private String login;
	
	private String password;
	
	private String role;
	
	private String phone;
	
	private String address;

	private Boolean sicked;

	public Boolean getSicked() {
		return sicked;
	}

	public void setSicked(Boolean sicked) {
		this.sicked = sicked;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
