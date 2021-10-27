package com.revature.models;

public class ReviewDTO {

	//whole purpose is for login functionality
	
	private int userId;
	private int animeId;
	private double score;
	private String review;
	
	//boilerplate code---------------------------------------------
	
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int userId, int animeId, double score, String review) {
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
