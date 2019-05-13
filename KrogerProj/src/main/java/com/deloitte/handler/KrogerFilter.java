package com.deloitte.handler;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class KrogerFilter extends GenericFilterBean {
	
	@Autowired
	Environment env;
	
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) 
		throws IOException,ServletException{
		
		final HttpServletRequest request = (HttpServletRequest) req;
		final String authorization = request.getHeader("authorization");
		if(authorization==null || !authorization.startsWith("Bearer ")) {
			throw new ServletException(env.getProperty("error_msg"));
			}
		try {
			final Claims claims=Jwts.parser().setSigningKey(env.getProperty("SignKey")).parseClaimsJws(authorization.substring(7))
					.getBody();
			request.setAttribute("claims",claims);
		}catch(final SignatureException e) {
			throw new ServletException(env.getProperty("error_msg"));
		}
		chain.doFilter(req, res);
	}

}
