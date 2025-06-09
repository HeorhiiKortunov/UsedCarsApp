package com.example.demo.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
@NamedQueries({
		@NamedQuery(
				name = "Comments.getByPost",
				query = "SELECT c FROM Comments c WHERE c.post = :post"
		)
})
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String text;

	@ManyToOne
	@JoinColumn(name = "comment_author_id", referencedColumnName = "id")
	private Users commentAuthor;

	@ManyToOne
	@JoinColumn(name = "comment_post_id", referencedColumnName = "id")
	private Posts post;


	public Comments() {}

	public Comments(long id, String text, Users commentAuthor) {
		this.id = id;
		this.text = text;
		this.commentAuthor = commentAuthor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Users getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(Users commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
}
