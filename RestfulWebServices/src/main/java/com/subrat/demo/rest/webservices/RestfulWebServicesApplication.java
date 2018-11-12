package com.subrat.demo.rest.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subrat.demo.rest.webservices.util.UserUtility;

@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {
	
	@Autowired
	private UserUtility userUtility;

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userUtility.createUsers();
	}
}
