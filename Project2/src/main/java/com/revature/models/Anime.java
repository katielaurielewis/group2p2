package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "anime")
public class Anime {

	@Id
	@Column(name = "anime_id")
	private int id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column
	private String rating;
	
	@Column(name = "user_rating")
	private double score;
	
	@Column
	private String synopsis;
	
	@Column
	private List<String> themes;
	
	@Column
	private List<String> studios;
	
	@OneToMany(mappedBy = "anime", fetch = FetchType.EAGER)
	private List<UserAnime> userAnimes;
	//This is how we'll get the many-to-many relationship working
	
	
}
