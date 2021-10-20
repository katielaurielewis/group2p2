package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.revature.models.Anime;
import com.revature.services.AnimeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/anilib")
public class AnimeController {
	

	private AnimeService aService;
	
	@Autowired
	public AnimeController(AnimeService aService) {
		super();
		this.aService = aService;
	}
	
	@GetMapping
	public ResponseEntity<List<Anime>> getAllAnime(){
		return ResponseEntity.status(200).body(aService.findAll());
	}
	
	@PostMapping
	public ResponseEntity addAnime(@RequestBody Anime a) {
		aService.save(a);
		return ResponseEntity.status(200).build();
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Anime> findById(@PathVariable int id){
		Anime a = aService.findById(id).get();
		return ResponseEntity.ok(a);
	}
	
	
	
	
	@GetMapping(value = "/name/{name}")  
	public ResponseEntity<List<Anime>> findByName(@PathVariable String title) {
		

		
		Optional<List<Anime>> opt = aService.findByTitle(title);

		
		List<Anime> animeList = null;
		
		if(opt.isPresent()) { 
			animeList = opt.get(); 
		}
		
		return ResponseEntity.ok(animeList);
		
	}

}

