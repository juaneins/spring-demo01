package com.fundamentos.springboot.springdemo.usecase;

import java.util.List;

import com.fundamentos.springboot.springdemo.entity.User;

public interface GetUser {
	
	List<User> getAll();

}
