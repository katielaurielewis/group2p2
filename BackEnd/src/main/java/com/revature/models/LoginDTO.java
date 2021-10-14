package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	//only models the username/password of our users
	//whole purpose is for login functionality
	
	private String username;
	private String password;
	
	//boilerplate code---------------------------------------------
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
