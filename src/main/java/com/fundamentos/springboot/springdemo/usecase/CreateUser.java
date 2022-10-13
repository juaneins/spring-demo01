package com.fundamentos.springboot.springdemo.usecase;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.service.UserService;

@Component
public class CreateUser {
	
	private UserService userService;
	
	public CreateUser(UserService userService) {
		this.userService = userService;
	}
	
	public User save(User newUser) {
		return userService.save(newUser);
	}

}
