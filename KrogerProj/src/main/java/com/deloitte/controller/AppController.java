package com.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@SuppressWarnings("unchecked")
	@RequestMapping("/secured/app")
	public ResponseEntity<Customer> verifyMyApp() {
		return restTemplate.getForObject("http://localhost:3030/Details/1", ResponseEntity.class);
	}
	
	
	
}
