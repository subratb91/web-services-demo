package com.subrat.demo.rest.webservices.controller.rest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.subrat.demo.rest.webservices.entity.HelloWorldBean;


@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

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
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}

}