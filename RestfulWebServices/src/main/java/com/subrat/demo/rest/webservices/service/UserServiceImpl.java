package com.subrat.demo.rest.webservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.demo.rest.webservices.entity.User;
import com.subrat.demo.rest.webservices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void createDemoUsers(List<User> users) {
		userRepository.saveAll(users);
	}

	@Override
	public boolean existsById(int id) {
		return userRepository.existsById(id);
	}

}
