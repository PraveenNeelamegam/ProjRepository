package com.deloitte.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.model.ApiToken;
import com.deloitte.model.Client;
import com.deloitte.repository.KrogerRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	@Autowired
	KrogerRepository repository;
	@Autowired
	Environment env;
	
	@PostMapping("/login")
	public ResponseEntity<ApiToken> login(@RequestBody Client client){
		if(repository.userAuthentication(client.getClientName(),client.getPasswordTxt())) {
			return new ResponseEntity<ApiToken>(
				new ApiToken(Jwts.builder().setSubject(client.getClientName())
				.claim("role","user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,env.getProperty("SignKey")).compact()),
				HttpStatus.OK);
		}else
			return new ResponseEntity<ApiToken>(
					new ApiToken(env.getProperty("error_msg")),HttpStatus.OK);
					
	}

}
