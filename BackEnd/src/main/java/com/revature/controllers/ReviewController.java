package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Anime;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.services.AnimeService;
import com.revature.services.ReviewService;
import com.revature.services.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/review")
public class ReviewController {

	private ReviewService rService;
	private AnimeService aService;
	private UserService uService;

	@Autowired
	public ReviewController(ReviewService rService, AnimeService aService, UserService uService) {
		super();
		this.rService = rService;
		this.aService = aService;
		this.uService = uService;
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
	public ResponseEntity<List<Review>> findByUser(@PathVariable int id) {

		User user = uService.findById(id);


		Optional<List<Review>> opt = rService.findByUser(user);


		List<Review> reviewList = null;

		if(opt.isPresent()) { 
			reviewList = opt.get(); 
		}

		return ResponseEntity.ok(reviewList);

	}

//	@PostMapping
//	public ResponseEntity addReview(@RequestBody Review review) {
//		
//		if(review == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		
//		rService.save(review);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

	//If our html is consistent with the following method, we can use it. But we can still use the above method (which I commented out).
	
	
	@PostMapping("/addReview")
	  public String addReview(@ModelAttribute Review review, Model model) {
	    model.addAttribute("review", review);
	    return "result"; //result is the name of a form called result.html and it should be stored inside the src/main/resources package. but we don't have it
	}



}
