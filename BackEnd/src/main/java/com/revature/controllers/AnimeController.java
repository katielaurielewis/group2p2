package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.AnimeDAO;
import com.revature.models.Anime;


@RestController
@RequestMapping(value="/anime")
public class AnimeController {
	

	private AnimeDAO aDAO;
	
	@Autowired
	public AnimeController(AnimeDAO aDAO) {
		super();
		this.aDAO = aDAO;
	}
	
	@GetMapping
	public ResponseEntity<List<Anime>> geAllAnime(){
		return ResponseEntity.status(200).body(aDAO.findAll());
	}
	
	@PostMapping
	public ResponseEntity addAnime(@RequestBody Anime a) {
		aDAO.save(a);
		return ResponseEntity.status(200).build();
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Anime> findById(@PathVariable int id){
		Anime a = aDAO.findById(id).get();
		return ResponseEntity.ok(a);
	}
	
	
	
	
	@GetMapping(value = "/name/{name}")  
	public ResponseEntity<List<Anime>> findByName(@PathVariable String name) {
		
		
		Optional<List<Anime>> optional = aDAO.findByTitle(name);
		
		List<Anime> animeList = null;
		
		if(optional.isPresent()) { 
			animeList = optional.get(); 
		}
		
		return ResponseEntity.ok(animeList);
		
	}
}