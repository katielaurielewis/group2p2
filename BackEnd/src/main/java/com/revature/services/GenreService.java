package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.GenreDAO;
import com.revature.models.Genre;

@Service
public class GenreService {

	private GenreDAO gDao;

	@Autowired
	public GenreService(GenreDAO gDao) {
		super();
		this.gDao = gDao;
	}


	public Optional<Genre> findByName(String name){
		return gDao.findByName(name);
	}


	public Genre save(Genre genre) {

		return gDao.save(genre);
	}
	
}
