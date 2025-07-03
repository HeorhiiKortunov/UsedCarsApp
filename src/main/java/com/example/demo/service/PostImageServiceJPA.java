package com.example.demo.service;

import com.example.demo.entities.PostImage;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostImageServiceJPA implements PostImageService{

	@Autowired
	EntityManager entityManager;

	@Override
	public void addImage(PostImage image) {
		entityManager.persist(image);
	}

	@Override
	public PostImage getById(long id) {
		return entityManager.createNamedQuery("PostImage.getById", PostImage.class).setParameter("id", id).getSingleResult();
	}
}
