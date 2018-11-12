package com.subrat.demo.rest.webservices.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.subrat.demo.rest.webservices.entity.HelloWorldBean;


@RestController
public class HelloWorldController {

	// @RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean getHelloWorldBean() { 

		/*
		 * Initial error There was an unexpected error (type=Internal Server Error,
		 * status=500). No converter found for return value of type: class
		 * com.subrat.demo.rest.webservices.beans.HelloWorldBean Solution : Provide a
		 * getter in Bean. Without bean conversion doesn't work
		 *
		 * Jackson2ObjectMapper converts bean to JSON and vice-versa
		 */

		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world/somePath/{name}")
	public HelloWorldBean getHelloWorldBeanWithPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}

}