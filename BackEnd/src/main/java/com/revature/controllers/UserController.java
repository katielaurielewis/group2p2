package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private UserService uService;
	
	@Autowired
	public UserController(UserService us) {
		super();
		this.uService = us;
	}
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User u){
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
		}
		
		return ResponseEntity.ok(u);
		
	}

}
