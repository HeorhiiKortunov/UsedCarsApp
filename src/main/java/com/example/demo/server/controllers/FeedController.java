package com.example.demo.server.controllers;

import com.example.demo.entities.Posts;
import com.example.demo.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class FeedController {

	@Autowired
	private PostsService postsService;

	@GetMapping("")
	public String redirect(){
		return "redirect:/feed";
	}

	@GetMapping("/feed")
	public String showFeed(
			@RequestParam(required = false) String make,
			@RequestParam(required = false) String model,
			@RequestParam(required = false) Integer year,
			@RequestParam(required = false) Integer mileage,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice,
			Model viewModel) {

		List<Posts> posts = postsService.getPostsFiltered(make, model, year, mileage, minPrice, maxPrice);

		viewModel.addAttribute("posts", posts);
		viewModel.addAttribute("make", make);
		viewModel.addAttribute("model", model);
		viewModel.addAttribute("year", year);
		viewModel.addAttribute("mileage", mileage);
		viewModel.addAttribute("minPrice", minPrice);
		viewModel.addAttribute("maxPrice", maxPrice);

		return "feed";
	}


}
