package com.example.demo.service;

import com.example.demo.entites.PostImage;

import java.util.List;

public interface PostImageService {
	public void addImage(PostImage image);
	public PostImage getById(long id);
}
