package com.fundamentos.springboot.springdemo.usecase;

import org.springframework.stereotype.Component;

import com.fundamentos.springboot.springdemo.service.UserService;

@Component
public class DeleteUser {
	
	private UserService userService;
	
	public DeleteUser(UserService userService) {
		this.userService = userService;
	}
	
	public void remove(Long id) {
		userService.delete(id);
	}

}
