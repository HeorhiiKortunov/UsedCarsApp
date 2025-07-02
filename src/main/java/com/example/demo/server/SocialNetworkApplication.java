package com.example.demo.server;

import com.example.demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.entites")
public class SocialNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);
	}

	@Bean
	public PostsService postsService(){ return new PostsServiceJPA();}

	@Bean
	public UsersService usersService(){ return new UsersServiceJPA();}

	@Bean
	public PostImageService postImageService(){ return new PostImageServiceJPA();}

}
