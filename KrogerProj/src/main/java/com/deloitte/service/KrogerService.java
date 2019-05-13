package com.deloitte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class KrogerService {
	
	@Autowired
	private Environment env;
	
	public int Authenticate(String name,int id) {
		//logger.info(env.getProperty("user_name")+" "+env.getProperty("password"));
		if(name.equalsIgnoreCase(env.getProperty("user_name"))&& id==Integer.parseInt(env.getProperty("password"))) {
			return 0;
			}
		else
			return 1;
	}

}
