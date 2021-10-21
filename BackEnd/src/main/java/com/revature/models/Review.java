package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "reviews")
@Component
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "anime_id")
	private Anime anime;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User author;
	
	@Column(name = "stars")
	private double starRating;
	
	@Column(name = "review")
	private String textReview;

	
	//boilerplate code ------------------------------------
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Review(int id, Anime anime, User author, double starRating, String textReview) {
		super();
		this.id = id;
		this.anime = anime;
		this.author = author;
		this.starRating = starRating;
		this.textReview = textReview;
	}


	public Review(Anime anime, User author, double starRating, String textReview) {
		super();
		this.anime = anime;
		this.author = author;
		this.starRating = starRating;
		this.textReview = textReview;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", anime=" + anime + ", author=" + author + ", starRating=" + starRating
				+ ", textReview=" + textReview + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anime == null) ? 0 : anime.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(starRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((textReview == null) ? 0 : textReview.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (anime == null) {
			if (other.anime != null)
				return false;
		} else if (!anime.equals(other.anime))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(starRating) != Double.doubleToLongBits(other.starRating))
			return false;
		if (textReview == null) {
			if (other.textReview != null)
				return false;
		} else if (!textReview.equals(other.textReview))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Anime getAnime() {
		return anime;
	}


	public void setAnime(Anime anime) {
		this.anime = anime;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public double getStarRating() {
		return starRating;
	}


	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}


	public String getTextReview() {
		return textReview;
	}


	public void setTextReview(String textReview) {
		this.textReview = textReview;
	}
	
	
}