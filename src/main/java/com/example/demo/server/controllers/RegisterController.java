package com.example.demo.server.controllers;

import com.example.demo.entities.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

	@Autowired
	UsersService usersService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String register(
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("password") String password
	){
		Users user = new Users();
		user.setUsername(username);
		user.setEmail(email);
		user.setPhone(phone);
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		user.setEnabled(true);

		usersService.addUser(user);

		System.out.println("All users: ");
		usersService.getAllUsers().forEach(u -> System.out.println(u.getUsername()));

		return "redirect:/feed";
	}

	@GetMapping("/register")
	public String registerForm(){
		return "register";
	}
}
