package com.deloitte.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KrogerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String user_query="select count(*) from users where username=? and password=?";
	
	public Boolean userAuthentication(String username,String password) {
			int res;
			res=jdbcTemplate.queryForObject(user_query,Integer.class,username,password);
			if(res>0) {
				return true;
			}else
				return false;
	}
}
