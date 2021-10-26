package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;
import com.revature.services.UserAnimeService;
import com.revature.services.UserService;
import com.revature.services.WatchStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/WatchStatus")
public class WatchStatusController {

	private WatchStatusService wsService;
	private UserAnimeService uAnimeService;
	private UserService uService;

	@Autowired
	public WatchStatusController(WatchStatusService wsService, UserAnimeService uAnimeService, UserService uService) {
		super();
		this.wsService = wsService;
		this.uAnimeService = uAnimeService;
		this.uService = uService;
	}

	@GetMapping(value = "/status/{status}")  
	public ResponseEntity<List<WatchStatus>> findByStatus(@PathVariable String status) {

		Optional<List<WatchStatus>> opt = wsService.findByStatus(status);


		List<WatchStatus> wsList = null;

		if(opt.isPresent()) { 
			wsList = opt.get(); 
		}

		return ResponseEntity.ok(wsList);

	}
	
	@PutMapping(value = "/user/{userId}/anime/{animeId}")
	public ResponseEntity updateWatchStatus(@PathVariable int userId, @PathVariable int animeId) {
		
		//Purpose of this controller method is to be able for the front end to change the status from not watched to watched
		Optional<List<UserAnime>> oUAnimeList = uAnimeService.findByUser(uService.findById(userId));
		
		if(!(oUAnimeList.isPresent())) { //validation for this method
			return ResponseEntity.noContent().build();
		}
		
		List<UserAnime> uAnimeList = oUAnimeList.get(); //Gathers list of UserAnime
		
		UserAnime uAnime = null;
		
		for(UserAnime ua : uAnimeList) {
			if(ua.getAnime().getId() == animeId) {
				//This would be the anime we wish to change
				uAnime = ua;
				break;
			}
		}
		
		if(uAnime == null) { //if the anime is still null, meaning it is not present
			return ResponseEntity.badRequest().build();
		}
		
		//Change the watch status of this entity
		uAnime.setWatchStatus(wsService.getById(2)); //set it to "Watched"
		
		//Finally, give this back to the database to update the value
		uAnimeService.save(uAnime);
		
		return ResponseEntity.ok().build();
	}

}
