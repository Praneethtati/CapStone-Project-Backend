package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.repo.Adminrepo;
import com.example.demo.service.AdminService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@Autowired
	Adminrepo repo;
	
	
	@PostMapping("/AdminInsert")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin ad)
	{
		return ResponseEntity.ok(service.adminInsert(ad));
	}
	
	@PostMapping("/AdminLogin")
	public ResponseEntity<Admin> adminlogin(@RequestBody Admin ad)
	{
		return ResponseEntity.ok(service.adminLogin(ad));
	}
	

}