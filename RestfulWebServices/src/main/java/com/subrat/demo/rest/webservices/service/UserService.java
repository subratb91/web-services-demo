package com.subrat.demo.rest.webservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subrat.demo.rest.webservices.entity.User;


public interface UserService {
	public void createDemoUsers(List<User> users);
	public List<User> getAllUsers();
	public User saveUser(User user);
	public User getUserById(int id);
	public void deleteById(int id);
	public boolean existsById(int id);
}
