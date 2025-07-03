package com.example.demo.service;

import com.example.demo.entities.PostImage;

public interface PostImageService {
	public void addImage(PostImage image);
	public PostImage getById(long id);
}
