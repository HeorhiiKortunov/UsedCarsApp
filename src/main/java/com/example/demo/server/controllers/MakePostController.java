package com.example.demo.server.controllers;

import com.example.demo.entities.PostImage;
import com.example.demo.entities.Posts;
import com.example.demo.entities.Users;
import com.example.demo.service.PostImageService;
import com.example.demo.service.PostsService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MakePostController {
	@Autowired
	PostsService postsService;

	@Autowired
	UsersService usersService;

	@Autowired
	PostImageService postImageService;

	@GetMapping("/user/makePost")
	public String showPostForm(){
		return "postForm";
	}

	@PostMapping("/user/makePost")
	public String makePost(
			@RequestParam("make") String make,
			@RequestParam("model") String model,
			@RequestParam("year") int year,
			@RequestParam("mileage") int mileage,
			@RequestParam("price") int price,
			@RequestParam("authorId") Long authorId,
			@RequestParam("images") MultipartFile[] images) {

		Users postAuthor = usersService.getById(authorId);

		Posts post = new Posts();
		post.setPostAuthor(postAuthor);
		post.setMake(make);
		post.setModel(model);
		post.setYear(year);
		post.setMileage(mileage);
		post.setPrice(price);

		postsService.addPost(post);

		for (MultipartFile imageFile : images) {
			if (!imageFile.isEmpty()) {
				PostImage postImage = new PostImage();
				postImage.setPost(post);
				try {
					postImage.setImage_data(imageFile.getBytes());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				postImageService.addImage(postImage);

			}
		}

		return "redirect:/feed";
	}
}
