package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "watchers")
public class Watchers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "watchers_id")
	private int id;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "anime_id")
	private Anime anime;
	
	@OneToMany(mappedBy = "watchers", fetch = FetchType.EAGER)
	private List<User> users;
	
}
