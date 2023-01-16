package com.hostmdy.model;

public class Moderator {
	public int id;
	public String email;
	public String password;
	public Moderator(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Moderator(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Moderator [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	
}
