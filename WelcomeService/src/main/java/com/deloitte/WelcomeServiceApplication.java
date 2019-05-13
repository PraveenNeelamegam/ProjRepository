package com.deloitte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WelcomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeServiceApplication.class, args);
	}

}
