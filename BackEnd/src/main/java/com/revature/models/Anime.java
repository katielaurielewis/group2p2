package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Anime")
@Component
public class Anime {

	@Id
	@Column(name = "anime_id")
	private int id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "maturity_rating")
	private String rating;
	
	@Column(name = "user_rating")
	private double score;
	
	@Column
	private String synopsis;
	
	@Column(name = "image_url")
	private String image;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Genre.class)
	@JoinColumn(name = "genre_id")
	private Genre themes;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Studio.class)
	@JoinColumn(name = "studio_id")
	private Studio studios;
	
	@JsonIgnore
	@OneToMany(mappedBy = "anime", fetch = FetchType.LAZY)
	private List<UserAnime> userAnimes;
	//This is how we'll get the many-to-many relationship working

	
	//boilerplate code ------------------------------------------------
	
	public Anime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Anime(int id, String title, String rating, double score, String synopsis, String image, Genre themes,
			Studio studios, List<UserAnime> userAnimes) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.score = score;
		this.synopsis = synopsis;
		this.image = image;
		this.themes = themes;
		this.studios = studios;
		this.userAnimes = userAnimes;
	}
	
	public Anime(String title, String rating, double score, String synopsis, String image, Genre themes, Studio studios,
			List<UserAnime> userAnimes) {
		super();
		this.title = title;
		this.rating = rating;
		this.score = score;
		this.synopsis = synopsis;
		this.image = image;
		this.themes = themes;
		this.studios = studios;
		this.userAnimes = userAnimes;
	}
	
	@Override
	public String toString() {
		return "Anime [id=" + id + ", title=" + title + ", rating=" + rating + ", score=" + score + ", synopsis="
				+ synopsis + ", image=" + image + ", themes=" + themes + ", studios=" + studios + ", userAnimes="
				+ userAnimes + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((studios == null) ? 0 : studios.hashCode());
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((themes == null) ? 0 : themes.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userAnimes == null) ? 0 : userAnimes.hashCode());
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
		Anime other = (Anime) obj;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (studios == null) {
			if (other.studios != null)
				return false;
		} else if (!studios.equals(other.studios))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userAnimes == null) {
			if (other.userAnimes != null)
				return false;
		} else if (!userAnimes.equals(other.userAnimes))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Genre getThemes() {
		return themes;
	}
	
	public void setThemes(Genre themes) {
		this.themes = themes;
	}
	
	public Studio getStudios() {
		return studios;
	}
	
	public void setStudios(Studio studios) {
		this.studios = studios;
	}
	
	public List<UserAnime> getUserAnimes() {
		return userAnimes;
	}
	
	public void setUserAnimes(List<UserAnime> userAnimes) {
		this.userAnimes = userAnimes;
	}
	
	
}
