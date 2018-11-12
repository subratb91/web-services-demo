package com.subrat.demo.rest.webservices.controller.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.subrat.demo.rest.webservices.entity.User;
import com.subrat.demo.rest.webservices.exception.UserNotFoundException;
import com.subrat.demo.rest.webservices.service.UserService;

@RestController
public class UserResource {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUserById(@PathVariable int id) {
		if(!userService.existsById(id)) {
			throw new UserNotFoundException("id-" + id + " not found");
		}
		return userService.getUserById(id);
	}
	
	@PostMapping("users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		if(!userService.existsById(id)) {
			throw new UserNotFoundException("id-" + id + " not found");
		}
		userService.deleteById(id);
	}
}
