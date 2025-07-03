package com.example.demo.service;

import com.example.demo.entities.Posts;
import com.example.demo.entities.Users;

import java.util.List;

public interface PostsService {
	public void addPost(Posts post);
	public List<Posts> getPostsByUser(Users author);
	public List<Posts> getAllPosts();
	public List<Posts> getPostsFiltered(String make, String model, Integer year, Integer mileage, Double minPrice, Double maxPrice);
	public Posts getById(long id);

}
