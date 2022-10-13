package com.fundamentos.springboot.springdemo.usecase;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.service.UserService;

@Component
public class UpdateUser {
	
	private UserService userService;
	
	public UpdateUser(UserService userService) {
		this.userService = userService;
	}

	public User update(User newUser, Long id) {
		return userService.update(newUser, id);
	}

}
