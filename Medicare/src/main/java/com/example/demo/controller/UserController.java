package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.Userrepo;
import com.example.demo.service.UserService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	Userrepo urepo;
	
	
	
	@PostMapping("/user")
	public ResponseEntity<User> adduser(@RequestBody User u){
		
		return ResponseEntity.ok(service.addUser(u));
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUser(){
		return service.getAllUser();
	}

	@GetMapping("/getuserby/{id}")
	public ResponseEntity<User>getUserById (@PathVariable int id){
		
		return ResponseEntity.ok(service.getUserById(id));
		
	}
	
    @PutMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User newUser){
    	
    	return ResponseEntity.ok(service.updateUser(newUser));
    	
    }
    
    @DeleteMapping("/UserDelete/{id}")
	public ResponseEntity<Boolean>deleteUser(@PathVariable int id){
    	
    	return ResponseEntity.ok(service.deleteUser(id));
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<User> loginuser(@RequestBody User u){
    	
    	return ResponseEntity.ok(service.login(u));
    }
    
}


	
