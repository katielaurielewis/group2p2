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
import com.revature.models.Review;
import com.revature.models.ReviewDTO;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.services.AnimeService;
import com.revature.services.ReviewService;
import com.revature.services.UserAnimeService;
import com.revature.services.UserService;
import com.revature.services.WatchStatusService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/review")
public class ReviewController {

	private ReviewService rService;
	private AnimeService aService;
	private UserService uService;
	private UserAnimeService uAnimeService;
	private WatchStatusService wsService;

	@Autowired
	public ReviewController(ReviewService rService, AnimeService aService, UserService uService,  UserAnimeService uAnimeService, WatchStatusService wsService) {
		super();
		this.rService = rService;
		this.aService = aService;
		this.uService = uService;
		this.uAnimeService = uAnimeService;
		this.wsService = wsService;
	}




	@GetMapping(value = "/anime/{id}")  
	public ResponseEntity<List<Review>> findByAnime(@PathVariable int id) {

		Optional<Anime> anime = aService.findById(id);



		Optional<List<Review>> opt = rService.findByAnime(anime);


		List<Review> reviewList = null;

		if(opt.isPresent()) { 
			reviewList = opt.get(); 
		}

		return ResponseEntity.ok(reviewList);

	}

	@GetMapping(value = "/user/{id}")  
	public ResponseEntity<List<ReviewDTO>> findByUser(@PathVariable int id) {

		User user = uService.findById(id);


		Optional<List<Review>> opt = rService.findByUser(user);


		List<Review> reviewList = null;

		if(opt.isPresent()) { 
			reviewList = opt.get(); 
		}
		
		List<ReviewDTO> response = new ArrayList<ReviewDTO>();
		reviewList.forEach( it -> {
			response.add(new ReviewDTO(
					it.getUser().getId(),
					it.getAnime().getId(),
					it.getStarRating(),
					it.getTextReview()
				));
		});

		return ResponseEntity.ok(response);

	}

	/*@PostMapping(value = "/user/{userId}/anime/{animeId}")
	public ResponseEntity addReview(@RequestBody Review review, @PathVariable int userId, @PathVariable int animeId) {
		
		if(review == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		//Receive our anime and user from the path
		User u = uService.findById(userId);
		Anime a = aService.findById(animeId).get();
		
		//------------------------------------------------------------------------------------------------
		//Nice Funtionality will be to allow making a review to also change the watch status
		List<UserAnime> uAnimeList = uAnimeService.findByUser(u).get(); //Gathers list of UserAnime
		
		UserAnime uAnime = null;
		
		for(UserAnime ua : uAnimeList) {
			if(ua.getAnime().getId() == animeId) {
				//This would be the anime we wish to change
				uAnime = ua;
				break;
			}
		}
		
		//Change the watch status of this entity
		uAnime.setWatchStatus(wsService.getById(2)); //set it to "Watched"
		
		//Finally, give this back to the database to update the value
		uAnimeService.save(uAnime);
		//------------------------------------------------------------------------------------------------
		
		//Place them into the review
		review.setAnime(a);
		review.setUser(u);
		
		rService.save(review);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}*/
	
	@PostMapping
	public ResponseEntity<Review> addReview(@RequestBody ReviewDTO review) { 
		if(review == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		User u = uService.findById(review.getUserId());
		Anime a = aService.findById(review.getAnimeId()).get();
		
		Review r = new Review();
		r.setAnime(a);
		r.setUser(u);
		r.setStarRating(review.getScore());
		r.setTextReview(review.getReview());
		
		rService.save(r);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}



}
