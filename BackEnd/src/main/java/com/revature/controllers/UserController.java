package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
public class UserController {
	
	private UserService uService;
	
	@Autowired
	public UserController(UserService us) {
		super();
		this.uService = us;
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@RequestBody User u){
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
		}
		
		uService.addUser(u);
		
		return ResponseEntity.ok(u);
		
	}
	
	@GetMapping(value = "/{username}")  
	public ResponseEntity<User> findByUserName(@PathVariable String username) {

		User user = uService.findByUsername(username);

		return ResponseEntity.ok(user);

	}

}
