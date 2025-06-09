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
		)
})
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Users postAuthor;

	private long likes;


	public Posts() {}

	public Posts(long id, Users author, long likes) {
		this.id = id;
		this.postAuthor = author;
		this.likes = likes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getAuthor() {
		return postAuthor;
	}

	public void setAuthor(Users author) {
		this.postAuthor = author;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

}
