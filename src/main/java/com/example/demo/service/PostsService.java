package com.example.demo.service;

import com.example.demo.entites.Posts;
import com.example.demo.entites.Users;

import java.util.List;

public interface PostsService {
	public void addPost(Posts post);
	public List<Posts> getPostsByUser(Users author);
	public List<Posts> getAllPosts();
}
