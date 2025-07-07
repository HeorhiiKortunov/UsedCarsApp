package com.example.demo.service;

import com.example.demo.entities.Posts;
import com.example.demo.entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
		return entityManager.createNamedQuery("Posts.getByUser", Posts.class).setParameter("postAuthor", author).getResultList();
	}

	@Override
	public List<Posts> getAllPosts() {
		return entityManager.createNamedQuery("Posts.getAllPosts", Posts.class).getResultList();
	}

	@Override
	public List<Posts> getPostsFiltered(String make, String model, Integer year, Integer mileage, Double minPrice, Double maxPrice) {
		StringBuilder jpql = new StringBuilder("SELECT DISTINCT p FROM Posts p LEFT JOIN FETCH p.images WHERE 1=1");

		if (make != null && !make.isEmpty()) jpql.append(" AND LOWER(p.make) LIKE LOWER(:make)");
		if (model != null && !model.isEmpty()) jpql.append(" AND LOWER(p.model) LIKE LOWER(:model)");
		if (year != null) jpql.append(" AND p.year = :year");
		if (mileage != null) jpql.append(" AND p.mileage = :mileage");
		if (minPrice != null && maxPrice != null) jpql.append(" AND p.price BETWEEN :minPrice AND :maxPrice");

		TypedQuery<Posts> query = entityManager.createQuery(jpql.toString(), Posts.class);

		if (make != null && !make.isEmpty()) query.setParameter("make", "%" + make + "%");
		if (model != null && !model.isEmpty()) query.setParameter("model", "%" + model + "%");
		if (year != null) query.setParameter("year", year);
		if (mileage != null) query.setParameter("mileage", mileage);
		if (minPrice != null && maxPrice != null) {
			query.setParameter("minPrice", minPrice);
			query.setParameter("maxPrice", maxPrice);
		}

		return query.getResultList();
	}



	@Override
	public Posts getById(long id) {
		String jpql = "SELECT p FROM Posts p LEFT JOIN FETCH p.images WHERE p.id = :id";
		return entityManager.createQuery(jpql, Posts.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
