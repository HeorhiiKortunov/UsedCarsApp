package com.example.demo.server.controllers;

import com.example.demo.entites.PostImage;
import com.example.demo.service.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostImageController {
	@Autowired
	PostImageService postImageService;

	@GetMapping("/images/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
		PostImage image = postImageService.getById(id);
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(image.getImage_data());
	}

}
