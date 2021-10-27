package com.revature.models;

public class ReviewDTO {

	//whole purpose is for login functionality
	
	private int userId;
	private int animeId;
	private int score;
	private String review;
	
	//boilerplate code---------------------------------------------
	
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int userId, int animeId, int score, String review) {
		super();
		this.userId = userId;
		this.animeId = animeId;
		this.score = score;
		this.review = review;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAnimeId() {
		return animeId;
	}

	public void setAnimeId(int animeId) {
		this.animeId = animeId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
