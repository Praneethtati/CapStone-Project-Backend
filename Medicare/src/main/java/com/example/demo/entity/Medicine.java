package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Medicine {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
		String name;
		int mrp;
		int quantity;
		String category;
		String drug_description;


}
