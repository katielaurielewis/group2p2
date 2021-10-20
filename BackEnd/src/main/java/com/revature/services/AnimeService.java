package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.AnimeDAO;
import com.revature.models.Anime;

@Service
public class AnimeService {
	
	private AnimeDAO aDAO;
	
	@Autowired
	public AnimeService(AnimeDAO aDAO) {
		this.aDAO = aDAO;
	}
	
	public Optional<List<Anime>> findByTitle(String title){
		return aDAO.findByTitle(title);
	}
	
	public Optional<Anime> findById(int id){
		return aDAO.findById(id);
	}

	public List<Anime> findAll() {
		return aDAO.findAll();
	}

	public void save(Anime anime) {
		aDAO.save(anime);
	}

}
