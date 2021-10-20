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
import com.revature.models.Studio;
import com.revature.services.StudioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/studio")
public class StudioController {
	
	private StudioService sService;

	
	@Autowired
	public StudioController(StudioService sService) {
		super();
		this.sService = sService;
	}

	@GetMapping(value = "/name/{name}")  
	public ResponseEntity<List<Studio>> findByName(@PathVariable String name) {
		

		
		Optional<List<Studio>> opt = sService.findByName(name);

		
		List<Studio> studioList = null;
		
		if(opt.isPresent()) { 
			studioList = opt.get(); 
		}
		
		return ResponseEntity.ok(studioList);
		
	}
	
}
