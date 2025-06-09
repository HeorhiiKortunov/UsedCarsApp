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
		)
})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;


	public Users() {}

	public Users(long id, String username) {
		this.id = id;
		this.username = username;
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
}
