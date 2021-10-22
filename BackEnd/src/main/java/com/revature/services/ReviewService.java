package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.ReviewDAO;
import com.revature.models.Anime;
import com.revature.models.Review;
import com.revature.models.User;

@Service
public class ReviewService {

	private ReviewDAO rDao;

	@Autowired
	public ReviewService(ReviewDAO rDao) {
		super();
		this.rDao = rDao;
	}

	public Optional<List<Review>> findByAnime(Optional<Anime> anime){
		return rDao.findByAnime(anime);
	}

	public Optional<List<Review>> findByUser(User user){
		return rDao.findByUser(user);
	}

	public void save(Review review) {
		rDao.save(review);
	}

}
