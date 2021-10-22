package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Genre;
import com.revature.services.GenreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/genre")
public class GenreController {

	private GenreService gService;

	@Autowired
	public GenreController(GenreService gService) {
		super();
		this.gService = gService;
	}

	@GetMapping(value = "/name/{name}")  
	public ResponseEntity<Genre> findByName(@PathVariable String name) {



		Optional<Genre> opt = gService.findByName(name);


		if(opt.isPresent()) { 
			Genre genre = opt.get(); 
			return ResponseEntity.ok(genre);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}