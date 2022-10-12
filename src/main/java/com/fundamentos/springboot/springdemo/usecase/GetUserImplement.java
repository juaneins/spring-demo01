package com.fundamentos.springboot.springdemo.usecase;

import java.util.List;

import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.service.UserService;

public class GetUserImplement implements GetUser {
	
	private UserService userService;
	
	public GetUserImplement(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> getAll() {
		return userService.getAllUsers();
	}

}
