package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

	// Service objects to test with
	public AnimeService as;
	public UserService us;
	public LoginService ls;

	@Autowired
	public BackEndApplicationTests(UserService us, LoginService ls, AnimeService as) {
		super();
		this.us = us;
		this.ls = ls;
		this.as = as;
	}

	// variables and objects to use within tests
	public static User u = new User();
	public static Anime a = new Anime();
	public static Genre g = new Genre();
	public static UserAnime uAnime = new UserAnime();
	public static Studio s = new Studio();
	public static Review r = new Review();
	public static WatchStatus ws = new WatchStatus();
	public boolean result;
	public int id;
	public String uname;
	public String pass;

	@BeforeAll
	public static void createServices() {

		// also want to set the fields here, so we don't run into problems about which
		// test goes first
		// set user fields
		u.setUsername("testuser");
		u.setPassword("test");
		u.setEmail("test@gmail.com");
		u.setfName("Tess");
		u.setlName("Tear");

		g.setId(200);
		g.setName("Unit Testing"); // just some random test genre that hopefully won't conflict

		s.setId(400);
		s.setName("Testimation");

		ws.setStatus("Just Testing");

		a.setId(30000);
		a.setRating("T");
		a.setScore(3.14);
		List<Studio> slist = new ArrayList<>();
		slist.add(s);
		a.setStudios(slist);
		List<Genre> glist = new ArrayList<>();
		glist.add(g);
		a.setThemes(glist);
		a.setTitle("TokyoTest!!!");
		a.setSynopsis("I just want to test this method");

		uAnime.setAnime(a);
		uAnime.setUser(u);
		uAnime.setWatchStatus(ws);

		r.setAnime(a);
		r.setAuthor(u);
		r.setStarRating(4.1);
		r.setTextReview("Was pretty good");

	}

	@AfterAll
	public static void clearServices() {

	}

	// Going to test the Login method first --------------------------------

	@Test
	public void testLogin() {

		uname = "testUsername"; // these are valid credentials in the database
		pass = "testPassword";

		result = ls.checkCredentials(uname, pass);

		assertTrue(result);
		// test passes if credentials match a user in the DB

	}

	@Test
	public void testFailedLogin() {

		uname = "gsbauigbiusb";
		pass = "fhasblias";

		result = ls.checkCredentials(uname, pass);

		assertFalse(result);
		// test passes if credentials do not match a user in the DB

	}

	// Now, let's test the select/get methods -----------------------------

	@Test
	public void testGetAllAnimes() {

		List<Anime> aList = as.findAll();

		assertNotNull(aList);

	}

	@Test
	public void testGetAnimeById() {

		id = 1; // this should give us Cowboy Bebop

		Optional<Anime> oa = as.findById(id);

		assertTrue(oa.isPresent());

	}

	@Test
	public void testGetAnimeByWrongId() {

		id = 2; // strangely, the id of 2 does not correlate to any Anime

		Optional<Anime> oa = as.findById(id);

		assertFalse(oa.isPresent());

	}

	// Now for the UserService method

	@Test
	public void testAddUser() {

		result = us.addUser(u);

		assertTrue(result);
	}

	// Other Add methods:

//	@Test
//	public void testAddGenre() {
//		
//		result = as.addGenre(g);
//		
//		assertTrue(result);
//	}
//
//	@Test
//	public void testAddStudio() {
//
//		result = as.addStudio(s);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testAddWatchStatus() {
//		
//		result = as.addWatchStatus(ws);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testAddAnime() {
//		
//		result = as.addAnime(a);
//		
//		assertTrue(result);
//		
//	}
//	
//	@Test
//	public void testAddUserAnime() {
//		
//		result = as.addUserAnime(uAnime);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testAddReview() {
//
//		result = as.addReview(r);
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testUpdateStatus() {
//		WatchStatus ws2 = new WatchStatus(4, "Testing Differently");
//		uAnime.setWatchStatus(ws2);
//		
//		result = as.updateAnimeWatchStatus(uAnime);
//		
//		assertTrue(result);
//	}

	
}

