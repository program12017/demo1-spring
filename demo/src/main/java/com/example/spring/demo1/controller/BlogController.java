package com.example.spring.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.demo1.service.BlogService;
import com.example.spring.demo1.model.Blog;

@RestController
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> select() {
		return new ResponseEntity<List<Blog>>(blogService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
	public ResponseEntity<Blog> selectById(@PathVariable("id") int id) {
		return new ResponseEntity<Blog>(blogService.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ResponseEntity<Blog> create(@RequestBody Blog blog) {
		return new ResponseEntity<Blog>(blogService.save(blog), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.PUT)
	public ResponseEntity<Blog> update(@RequestBody Blog blog) {
		return new ResponseEntity<Blog>(blogService.save(blog), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		
		Blog blog = blogService.findById(id);
		
		if (blog != null) {
			blogService.delete(blog);
		}
		
		
		return new ResponseEntity<String>("Blog deleted", blog == null ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
	}
	
}
