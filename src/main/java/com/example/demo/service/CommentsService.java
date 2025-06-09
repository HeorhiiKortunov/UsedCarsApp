package com.example.demo.service;

import com.example.demo.entites.Comments;
import com.example.demo.entites.Posts;

import java.util.List;

public interface CommentsService {
	public void addComment(Comments comment);
	public List<Comments> getCommentsByPost(Posts post);
}
