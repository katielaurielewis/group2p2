package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.AnimeDAO;
import com.revature.models.Anime;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.services.UserAnimeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping("/library")
public class UserAnimeController {

	private UserAnimeService uas;
	private AnimeDAO aDao;
	
	@Autowired
	public UserAnimeController(UserAnimeService uas, AnimeDAO aDao) {
		this.uas = uas;
		this.aDao = aDao;
	}
	
	
	//I'm putting this here right now, we can move it later but I think that right now this is the easiest way to show it without causing error
	//Could also possibly do this in either the Anime or User Controller to get a specific user from the DB, then get their library from the model
	@GetMapping
	public ResponseEntity<List<Anime>> findUserLibrary(@RequestBody User u){
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Optional<List<UserAnime>> uAnimeList = uas.findByUser(u);
		
		if(uAnimeList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		List<Anime> aList = new ArrayList<>();
		
		for(UserAnime uAnime : uAnimeList.get()) {
			aList.add(aDao.getById(uAnime.getAnime().getId()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(aList);
	}
	
}
