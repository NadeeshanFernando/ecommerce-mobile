package edu.demo.livedinner.model;

import java.util.HashSet;
public class Employee {

    private int id;
    private String username;
    private String lastname;
    private String email;
    private String password;
    private String phone;
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Employee(int id, String username, String lastname, String email, String password, String phone, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.enabled = enabled;
	}

	public Employee(String username, String lastname, String email, String password, String phone, boolean enabled) {
		super();
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.enabled = enabled;
	}

	public Employee(int id, String username, String lastname, String email, String password, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Employee(String username, String lastname, String email, String password, String phone) {
		super();
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", username='" + username + '\'' +
				", lastname='" + lastname + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", enabled=" + enabled +
				'}';
	}
}
