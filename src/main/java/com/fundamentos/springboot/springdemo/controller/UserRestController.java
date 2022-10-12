/**
 * 
 */
package com.fundamentos.springboot.springdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentos.springboot.springdemo.entity.User;
import com.fundamentos.springboot.springdemo.usecase.GetUser;

/**
 * @author juaneins_uio
 *
 */
@RestController
@RequestMapping("api/users")
public class UserRestController {
	
	private GetUser getUser;
	
	public UserRestController(GetUser getUser) {
		super();
		this.getUser = getUser;
	}

	@GetMapping("/")
	List<User> get() {
		return getUser.getAll();
	}
}
