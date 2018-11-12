package com.subrat.demo.rest.webservices.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.subrat.demo.rest.webservices.entity.User;
import com.subrat.demo.rest.webservices.service.UserService;

@Component
public class UserUtility {
	
	@Autowired
	private UserService userService;
	
	public void createUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("Harvey",new Date()));
		users.add(new User("Mike",new Date()));
		users.add(new User("Donna",new Date()));
		userService.createDemoUsers(users);
	}
}
