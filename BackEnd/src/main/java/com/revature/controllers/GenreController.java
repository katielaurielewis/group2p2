package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Genre>> findByName(@PathVariable String name) {
		

		
		Optional<List<Genre>> opt = gService.findByName(name);

		
		List<Genre> genreList = null;
		
		if(opt.isPresent()) { 
			genreList = opt.get(); 
		}
		
		return ResponseEntity.ok(genreList);
		
	}

}
