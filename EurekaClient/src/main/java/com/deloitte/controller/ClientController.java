package com.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.model.UserResponse;

@RestController
public class ClientController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/welcome")
	public String clientController() {
		
		return restTemplate.getForObject("http://WELCOMESERVICE/welcome/", String.class);
	}
	
	@RequestMapping("/welcome123")
	public String clController() {
		
		return restTemplate.getForObject("http://10.20.253.23:4321/welcome123/", String.class);
	}
	
	@RequestMapping("/login")
	public String KrogerclientController() {
		
		return restTemplate.getForObject("http://KROGERCLIENT/user/", String.class);
	}
	
	@RequestMapping("/client")
	public String EurekaClientController() {
		
		return "Hello From Eureka Client";
	}
	
	
	
}
