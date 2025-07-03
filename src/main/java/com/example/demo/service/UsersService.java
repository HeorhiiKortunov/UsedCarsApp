package com.example.demo.service;

import com.example.demo.entities.Users;
import java.util.List;

public interface UsersService {
	public void addUser(Users user);
	public List<Users> getAllUsers();
	public Users getById(long id);
}
