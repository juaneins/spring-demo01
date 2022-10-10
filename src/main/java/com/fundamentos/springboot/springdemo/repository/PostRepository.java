package com.fundamentos.springboot.springdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fundamentos.springboot.springdemo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
