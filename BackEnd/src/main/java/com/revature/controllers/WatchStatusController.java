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

import com.revature.models.WatchStatus;

import com.revature.services.WatchStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/WatchStatus")
public class WatchStatusController {

	private WatchStatusService wsService;

	@Autowired
	public WatchStatusController(WatchStatusService wsService) {
		super();
		this.wsService = wsService;
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

}
