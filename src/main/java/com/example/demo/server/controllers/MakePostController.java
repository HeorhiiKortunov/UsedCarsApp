package com.example.demo.server.controllers;

import com.example.demo.entites.Posts;
import com.example.demo.entites.Users;
import com.example.demo.service.PostsService;
import com.example.demo.service.UsersService;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakePostController {
	@Autowired
	PostsService postsService;

	@Autowired
	UsersService usersService;

	@GetMapping("/makePost")
	public String showPostForm(){
		return "postForm";
	}

	@PostMapping("/makePost")
	public String makePost(
			@RequestParam("make") String make,
			@RequestParam("model") String model,
			@RequestParam("year") int year,
			@RequestParam("mileage") int mileage,
			@RequestParam("price") int price,
			@RequestParam("authorId") Long authorId) {

		Users postAuthor = usersService.getById(authorId);

		Posts post = new Posts();
		post.setPostAuthor(postAuthor);
		post.setMake(make);
		post.setModel(model);
		post.setYear(year);
		post.setMileage(mileage);
		post.setPrice(price);

		postsService.addPost(post);

		return "redirect:/feed";
	}
}
