package com.deloitte.model;

public class ApiToken {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ApiToken(String token) {
		super();
		this.token=token;
	}
}
