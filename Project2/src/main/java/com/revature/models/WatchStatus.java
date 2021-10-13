package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//This model class is essentially just another table to list off the different status types

@Entity
@Table(name = "watch_statuses")
public class WatchStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int id;
	
	@Column(name = "status_name")
	private String status;
	
}
