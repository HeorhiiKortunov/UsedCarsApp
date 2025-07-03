package com.example.demo.service;

import com.example.demo.entities.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsersServiceJPA implements UsersService{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUser(Users user) {
		entityManager.persist(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return entityManager.createNamedQuery("Users.getAllUsers", Users.class).getResultList();
	}

	@Override
	public Users getById(long id) {
		return entityManager.createNamedQuery("Users.getById", Users.class).setParameter("id", id).getSingleResult();
	}
}
