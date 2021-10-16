package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
@ResponseBody
public class LoginController {
	
	private LoginService lService;
	
	@Autowired
	public LoginController(LoginService ls) {
		super();
		this.lService = ls;
	}
	
	@PostMapping
	public ResponseEntity<LoginDTO> checkCredentials(@RequestBody LoginDTO ldto){
		
		if(lService.checkCredentials(ldto.getUsername(), ldto.getPassword())) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}

}
