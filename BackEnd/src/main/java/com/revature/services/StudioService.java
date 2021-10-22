package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.StudioDAO;
import com.revature.models.Studio;


@Service
public class StudioService {
	
	private StudioDAO sDao;
	
	@Autowired
	public StudioService(StudioDAO sDao) {
		super();
		this.sDao= sDao;
	}
	
	public Optional<List<Studio>> findByName(String name){
		return sDao.findByName(name);
	}

	public Studio save(Studio s) {
		return sDao.save(s);
		
	}
	





}
