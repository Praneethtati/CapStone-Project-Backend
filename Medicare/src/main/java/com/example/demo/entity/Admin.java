package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Admin {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int aid;
	String aname;
	String aemail;
	String apassword;
	

}
