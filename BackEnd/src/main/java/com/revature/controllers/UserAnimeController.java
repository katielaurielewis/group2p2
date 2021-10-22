package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.revature.models.Anime;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.services.AnimeService;
import com.revature.services.UserAnimeService;
import com.revature.services.UserService;
import com.revature.services.WatchStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping("/library")
public class UserAnimeController {

	private UserAnimeService uas;
	private AnimeService as;
	private UserService us;
	private WatchStatusService ws;
	
	@Autowired
	public UserAnimeController(UserAnimeService uas, AnimeService as, UserService us, WatchStatusService ws) {
		this.uas = uas;
		this.as = as;
		this.us = us;
		this.ws = ws;
	}
	
	
	//I'm putting this here right now, we can move it later but I think that right now this is the easiest way to show it without causing error
	//Could also possibly do this in either the Anime or User Controller to get a specific user from the DB, then get their library from the model
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<Anime>> findUserLibrary(@PathVariable int userId){
		
		User u = us.findById(userId);
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Optional<List<UserAnime>> uAnimeList = uas.findByUser(u);
		
		if(!uAnimeList.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		List<Anime> aList = new ArrayList<>();
		
		for(UserAnime uAnime : uAnimeList.get()) {
			aList.add(as.findById(uAnime.getAnime().getId()).get());
		}
		return ResponseEntity.status(HttpStatus.OK).body(aList);
	}
	
	@GetMapping(value = "/user/{userId}/status/{statusId}")
	public ResponseEntity<List<Anime>> findAllAnimeByWatchStatus(@PathVariable int userId, @PathVariable int statusId){
		
		User u = us.findById(userId);
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Optional<List<UserAnime>> uAnimeList = uas.findByUser(u);
		
		if(!uAnimeList.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		List<Anime> aList = new ArrayList<>();
		
		for(UserAnime uAnime : uAnimeList.get()) {
			if(uAnime.getWatchStatus().getId() == statusId) { //if it is of correct status
				aList.add(as.findById(uAnime.getAnime().getId()).get());
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(aList);
		
	}
	
	@PostMapping
	public ResponseEntity addLibraryEntity(@RequestBody UserAnime uAnime) {
		//This method is to be able to add a new anime to their library
		
		if(uAnime.getWatchStatus() == null) {
			uAnime.setWatchStatus(ws.getById(1)); //sets to not watched, if they do not already claim it as watched
		}
		
		uas.save(uAnime);
		
		return ResponseEntity.ok().build();
	}
	
}
