package com.sopra;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @ Data class Contact {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String firstname;
	
	@Column 
	private String lastname;
	
	@Column
	private Date birthdate;
	
}
