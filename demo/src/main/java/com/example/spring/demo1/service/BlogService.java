package com.example.spring.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.demo1.model.Blog;
import com.example.spring.demo1.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public List<Blog> findAll() {
		return blogRepository.findAll();
	}
	
	public Blog findById(long id) {
		return blogRepository.findOne(id);
	}
	
	public Blog save(Blog blog) {
		return blogRepository.save(blog);
	}
	
	public void delete(Blog blog) {
		blogRepository.delete(blog);
	}
	
}
