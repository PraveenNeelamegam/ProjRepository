package com.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Autowired
	Environment environment;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome To Deloitte From Port "+environment.getProperty("local.server.port");
	}

}
