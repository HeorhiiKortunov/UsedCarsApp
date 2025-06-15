package com.example.demo.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(
				name = "Users.getAllUsers",
				query = "SELECT u FROM Users u"
		),
		@NamedQuery(
				name = "Users.resetUsers",
				query = "DELETE FROM Users"
		),
		@NamedQuery(
				name = "Users.getById",
				query = "SELECT u FROM Users u WHERE u.id = :id"
		)
})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;

	private String email;
	private int phone;


	public Users() {}

	public Users(long id, String username, String email, int phone) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}
