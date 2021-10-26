package com.revature.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Anime;
import com.revature.models.Genre;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.services.AnimeService;
import com.revature.services.GenreService;
import com.revature.services.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RequestMapping(value="/anilib")
public class AnimeController {
	

	private AnimeService aService;
	private GenreService gService;
	private UserService uService;
	
	@Autowired
	public AnimeController(AnimeService aService, GenreService gService, UserService uService) {
		super();
		this.aService = aService;
		this.gService = gService;
		this.uService = uService;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<List<Anime>> getAllAnime(){
		return ResponseEntity.status(200).body(aService.findAll());
	}
	
//	@PostMapping
//	public ResponseEntity addAnime(@RequestBody Anime a) {
//		aService.save(a);
//		return ResponseEntity.status(200).build();
//	}
	
	
	//If our html is consistent with the following method, we can use it. But we can still use the above method (which I commented out).
	
	
	@PostMapping("/addAnime")
	  public String addAnime(@ModelAttribute Anime anime, Model model) {
	    model.addAttribute("anime", anime);
	    
	    
	    aService.save(anime);
	    //Ok, we for sure need this^^ for this method to actually do anything with regards to the database
	    //That being said, We need to make sure to talk about this tommorow at standup, cause currently I don't think this is the way
	    
	    
	    return "result"; //result is the name of a form called result.html and it should be stored inside the src/main/resources package. but we don't have it
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
	
	@GetMapping(value = "/url/{url}")
	public ResponseEntity<Anime> findByImage(@PathVariable String url){
		Anime a = aService.findByImage(url).get();
		return ResponseEntity.ok(a);
	}
	
	
	//This method gets a random anime based on the User's wants
	@GetMapping(value = "/recommend/{userId}/{genre}/{rating}")
	public ResponseEntity<Anime> recommendAnime(@PathVariable int userId, @PathVariable String genre, @PathVariable String rating){
		Genre g = gService.findByName(genre).get();
		
		List<Anime> aList = aService.findAll();
		
		User u = uService.findById(userId);
		List<UserAnime> uLibrary = u.getLibrary();
		List<Anime> aList2 = new ArrayList<>();
		
		for (Anime a : aList) {
			
			List<Integer> animes = new ArrayList<>();
			
			for (UserAnime uAnime : uLibrary) {
				animes.add(uAnime.getAnime().getId());
				}
			
			if(!(animes.contains(a.getId()))) {
				aList2.add(a);
			}
			
			animes = null;
		}

		List<Anime> aList3 = new ArrayList<>();
		
		for (Anime a : aList2) {
			if(a.getRating().equals(rating) && a.getThemes().getName().equals(genre)) {
				//checks the rating and the genre of the anime
				//if there is a match, we add it
				aList3.add(a);
			}
		}
		
		
		int r = (int) (Math.random()*(aList3.size()));
		
		//Finally, we take a random Anime that is left over
		return ResponseEntity.ok(aList3.get(r));
	}

}

