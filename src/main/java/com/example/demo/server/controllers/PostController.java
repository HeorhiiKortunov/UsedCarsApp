package com.example.demo.server.controllers;

import com.example.demo.entities.Posts;
import com.example.demo.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	PostsService postsService;

	@GetMapping("/post")
	public String showPost(@RequestParam long id, Model viewModel){
		Posts post = postsService.getById(id);
		viewModel.addAttribute("post", post);
		viewModel.addAttribute("user", post.getPostAuthor());

		return "post";
	}

}
