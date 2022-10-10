package com.fundamentos.springboot.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentos.springboot.springdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
