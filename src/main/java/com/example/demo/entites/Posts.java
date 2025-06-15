package com.example.demo.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
@NamedQueries({
		@NamedQuery(
				name = "Posts.getAllPosts",
				query = "SELECT p FROM Posts p"
		),
		@NamedQuery(
				name = "Posts.getByUser",
				query = "SELECT p FROM Posts p WHERE p.postAuthor = :postAuthor"
		),
		@NamedQuery(
				name = "Posts.getById",
				query = "SELECT p FROM Posts p WHERE p.id = :id"
		)
})
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Users postAuthor;

	private String make;

	private String Model;

	private int year;

	private int mileage;

	private int price;


	public Posts() {}

	public Posts(long id, Users postAuthor, String make, String model, int year, int mileage, int price) {
		this.id = id;
		this.postAuthor = postAuthor;
		this.make = make;
		Model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(Users postAuthor) {
		this.postAuthor = postAuthor;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
