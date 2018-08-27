package com.example.spring.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.demo1.model.Blog;

//Jpa es un ORM de Java.
public interface BlogRepository extends JpaRepository<Blog, Long> {

	
}
