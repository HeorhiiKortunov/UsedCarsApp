package com.example.demo.service;

import com.example.demo.entites.Posts;
import com.example.demo.entites.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class PostsServiceJPA implements PostsService{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addPost(Posts post) {
		entityManager.persist(post);
	}

	@Override
	public List<Posts> getPostsByUser(Users author) {
		return entityManager.createNamedQuery("Posts.getByUser").setParameter("postAuthor", author).getResultList();
	}

	@Override
	public List<Posts> getAllPosts() {
		return entityManager.createNamedQuery("Posts.getAllPosts").getResultList();
	}
}
