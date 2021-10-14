package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Anime;
import com.revature.models.Genre;
import com.revature.models.Review;
import com.revature.models.Studio;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;
import com.revature.services.AnimeService;
import com.revature.services.LoginService;
import com.revature.services.UserService;

@SpringBootTest
class BackEndApplicationTests {

	//Service objects to test with
	public static AnimeService as;
	public static UserService us;
	public static LoginService ls;
	
	//variables and objects to use within tests
	public User u = new User();
	public Anime a = new Anime();
	public Genre g = new Genre();
	public UserAnime uAnime = new UserAnime();
	public Studio s = new Studio();
	public Review r = new Review();
	public WatchStatus ws = new WatchStatus();
	public boolean result;
	int id;
	
	@BeforeAll
	public static void createServices() {
		as = new AnimeService();
		us = new UserService();
		ls = new LoginService();
	}
	
	@AfterAll
	public static void clearServices() {
		as = null;
		us = null;
		ls = null;
	}
	
	//Going to test the Login method first --------------------------------
	
	@Test
	public void testLogin() {
		
		u.setUsername("validusername"); //make sure to edit this to an actual DB username
		u.setPassword("validpassword");
		
		result = ls.checkCredentials(u.getUsername(), u.getPassword());
		
		assertTrue(result);
		//test passes if credentials match a user in the DB
		
	}
	
	@Test
	public void testFailedLogin() {
		
		u.setUsername("gsbauigbiusb"); 
		u.setPassword("fhasblias");
		
		result = ls.checkCredentials(u.getUsername(), u.getPassword());
		
		assertFalse(result);
		//test passes if credentials do not match a user in the DB
		
	}
	
	//Now, let's test the select/get methods -----------------------------
	
	@Test
	public void testGetAllAnimes() {
		
		List<Anime> aList = as.getAllAnimes();
		
		assertNotNull(aList);
		
	}
	
	@Test
	public void testGetAnimeById() {
		
		id = 1; //this should give us Cowboy Bebop
		
		a = as.getAnimeById(id);
		
		assertNotNull(a);
		
	}
	
	@Test
	public void testGetAnimeByWrongId() {
		
		id = 2; //strangely, the id of 2 does not correlate to any Anime
		
		a = as.getAnimeById(id);
		
		assertNull(a);
		
	}
	
	@Test
	public void testGetRandomAnime() {
		
		id = 100; //just a random id
		
		a = as.getRandomAnime(id);
		
		assertNotNull(a);
		
	}

}
