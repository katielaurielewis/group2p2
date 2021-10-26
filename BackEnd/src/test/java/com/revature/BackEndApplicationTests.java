package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.revature.models.Anime;
import com.revature.models.Genre;
import com.revature.models.Studio;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;
import com.revature.services.AnimeService;
import com.revature.services.GenreService;
import com.revature.services.LoginService;
import com.revature.services.StudioService;
import com.revature.services.UserAnimeService;
import com.revature.services.UserService;
import com.revature.services.WatchStatusService;

@SpringBootTest
class BackEndApplicationTests {

	// Service objects to test with
	public AnimeService as;
	public UserService us;
	public LoginService ls;
	public GenreService gs;
	public UserAnimeService uas;
	public StudioService ss;
	public WatchStatusService wss;

	@Autowired
	public BackEndApplicationTests(UserService us, LoginService ls, AnimeService as, GenreService gs, UserAnimeService uas, StudioService ss, WatchStatusService wss) {
		super();
		this.us = us;
		this.ls = ls;
		this.as = as;
		this.gs = gs;
		this.uas = uas;
		this.ss = ss;
		this.wss = wss;
	}

	// variables and objects to use within tests
	public static User u = new User();
	public static Anime a = new Anime();
	public static Genre g = new Genre();
	public static UserAnime uAnime = new UserAnime();
	public static Studio s = new Studio();
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

		g.setId(401);
		g.setName("Unit Testing"); // just some random test genre that hopefully won't conflict

		s.setId(401);
		s.setName("Testimation");

		ws.setId(3);
		ws.setStatus("Testing");

		a.setId(30001);
		a.setRating("T");
		a.setScore(3.14);
		a.setStudios(s);
		a.setThemes(g);
		a.setTitle("TokyoTest!!!");
		a.setSynopsis("I just want to test this method");

		uAnime.setAnime(a);
		uAnime.setUser(u);
		uAnime.setWatchStatus(ws);

	}

	@AfterAll
	public static void clearServices() {
		u = null;
		a = null;
		g = null;
		uAnime = null;
		s = null;
		ws = null;
		
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

		u = us.addUser(u);

		assertTrue(u !=null);
	}

	// Other Add methods: ----------------------------------------------------
	
	//Since we are now using Spring JPA to simplify the DAO layer, these two 
	//tests should suffice for every other add method

	//I've decided to go with adding a Genre, since it is simple and easy
	@Test
	public void testAddGenre() {
		
		Genre savedGenre = gs.save(g);
		//If this gets persisted to the DB, this will return the saved object
		
		assertTrue(savedGenre.equals(g));
		//Test passes if database record is equal to our Java object
	}
	
	@Test
	public void testAddNull() {
		//you are not able to pass in a null object to the database
		//so, it works as a great negative test
		
		Genre nullGenre = null;
		
		assertThrows(InvalidDataAccessApiUsageException.class, () -> gs.save(nullGenre));
		
		//Test passes if the method throws an exception
	}


	@Test
	public void testUpdateStatus() {
		
		uAnime.getUser().setId(u.getId());
		//add initial useranime
		uAnime = uas.save(uAnime); //this way we get back the id
		//that will be needed if we want to update it instead of delete it
		
		//Change the UserAnime's watch status
		uAnime.setWatchStatus(wss.getById(2));
		
		UserAnime uAnime2 = uas.save(uAnime);
		
		assertTrue(uAnime2.getWatchStatus().getId() == 2);
		//Test passes if the new record is equal to our object
	}

	
}

