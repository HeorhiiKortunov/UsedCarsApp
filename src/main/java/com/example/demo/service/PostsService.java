package com.example.demo.service;

import com.example.demo.entites.Posts;
import com.example.demo.entites.Users;

public interface PostsService {
	public void addPost(Posts post);
	public void getPostsByUser(Users author);
}
