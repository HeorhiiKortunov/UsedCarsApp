package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = "Users.getAllUsers", query = "SELECT u FROM Users u"),
		@NamedQuery(name = "Users.resetUsers", query = "DELETE FROM Users"),
		@NamedQuery(name = "Users.getById", query = "SELECT u FROM Users u WHERE u.username = :username"),
		@NamedQuery(name = "Users.getByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
})
public class Users {

	@Id
	@Column(nullable = false, unique = true, length = 255)
	private String username;

	private String password;
	private boolean enabled;

	private String email;
	private String phone;

	public Users() {}

	public Users(String username, String password, boolean enabled, String email, String phone) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// Other getters/setters remain the same

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
}
