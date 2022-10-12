package com.fundamentos.springboot.springdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.springdemo.service.UserService;
import com.fundamentos.springboot.springdemo.usecase.GetUser;
import com.fundamentos.springboot.springdemo.usecase.GetUserImplement;

@Configuration
public class UseCaseConfiguration {
	
	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}

}
