package com.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.model.Customer;

@RestController
public class AppController {
	
	@Autowired
	Environment env;
	@Autowired
	RestTemplate restTemplate;

	@Value("${endpoint}")
	String endpoint;
	
	@RequestMapping("/welcome")
	public String WelcomeService() {
	return restTemplate.getForObject("http://WELCOMESERVICE/welcome/", String.class)	;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/secured/app")
	public Customer verifyMyApp() {
		RestTemplate restTem = new RestTemplate();
		return restTem.getForObject("http://localhost:3031/Details/1", Customer.class);
	}
		
	
}
