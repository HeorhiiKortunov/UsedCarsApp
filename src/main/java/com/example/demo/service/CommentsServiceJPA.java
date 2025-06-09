package com.example.demo.service;

import com.example.demo.entites.Comments;
import com.example.demo.entites.Posts;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class CommentsServiceJPA implements CommentsService{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addComment(Comments comment) {
		entityManager.persist(comment);
	}

	@Override
	public List<Comments> getCommentsByPost(Posts post) {
		return entityManager.createNamedQuery("Comments.getByPost").setParameter("post", post).getResultList();
	}
}
