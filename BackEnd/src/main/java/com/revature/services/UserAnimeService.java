package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserAnimeDAO;
import com.revature.models.User;
import com.revature.models.UserAnime;

@Service
public class UserAnimeService {

	private UserAnimeDAO uaDAO;
	
	@Autowired
	public UserAnimeService(UserAnimeDAO uaDAO) {
		this.uaDAO = uaDAO;
	}
	
	public Optional<List<UserAnime>> findByUser(User user){
		return uaDAO.findByUser(user);
	}

	public UserAnime save(UserAnime uAnime) {
		return uaDAO.save(uAnime);
	}
	
}
