package com.revature.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.APIGenre;
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
	
	@GetMapping(value = "/url/{url}")
	public ResponseEntity<Anime> findByImage(@PathVariable String url){
		Anime a = aService.findByImage(url).get();
		return ResponseEntity.ok(a);
	}
	
//	@GetMapping(value = "/recommend/{userId}/{genre}/{rating}")
//	public ResponseEntity<Anime> recommendAnime(@PathVariable int userId, @PathVariable String genre, @PathVariable String rating){
//		Genre g = gService.findByName(genre).get();
//		
//		APIGenre apig = this.restTemplate.getForObject("https://api.jikan.moe/v3/genre/anime/" + g.getId(), APIGenre.class);
//		
//		List<Anime> aList = apig.getAnime();
//		
//		User u = uService.findById(userId);
//		List<UserAnime> uLibrary = u.getLibrary();
//		
//		for(Anime a : aList) {
//			for(UserAnime uAnime : uLibrary) {
//				if(a.getId() == uAnime.getAnime().getId()) {
//					aList.remove(a);
//					break;
//				} else {
//					a.setRating(uAnime.getAnime().getRating());
//					//for some reason this API call doesn't grab the rating,
//					//so I'll just take it from our end
//				}
//			}
//		}
//		
//		Iterator<Anime> itr = aList.iterator();
//		
//		while(itr.hasNext()) {
//			Anime a = (Anime) itr.next();
//			if(a.getRating() != rating) {
//				//Not the rating the user wants
//				itr.remove();
//			}
//		}
//		
//		int r = (int) Math.random()*(aList.size()+1);
//		//Finally, we take a random Anime that is left over
//		
//		return ResponseEntity.ok(aList.get(r));
//	}
	
	
	//This method gets a random anime based on the User's wants
	//It uses the database, as opposed to trying to use the API like above
	@GetMapping(value = "/recommend/{userId}/{genre}/{rating}")
	public ResponseEntity<Anime> recommendAnime(@PathVariable int userId, @PathVariable String genre, @PathVariable String rating){
		Genre g = gService.findByName(genre).get();
		
		List<Anime> aList = aService.findAll();
		
		User u = uService.findById(userId);
		List<UserAnime> uLibrary = u.getLibrary();
		
		for (Anime a : aList) {
			for (UserAnime uAnime : uLibrary) {
				if (a.getId() == uAnime.getAnime().getId()) {
					aList.remove(a);
					break;
				}
			}
		}

		Iterator<Anime> itr = aList.iterator();

		while (itr.hasNext()) {
			Anime a = (Anime) itr.next();
			if (a.getRating() != rating) {
				// Not the rating the user wants
				itr.remove();
			}
		}
		
		
		int r = (int) Math.random()*(aList.size()+1);
		//Finally, we take a random Anime that is left over
		
		return ResponseEntity.ok(aList.get(r));
	}

}

