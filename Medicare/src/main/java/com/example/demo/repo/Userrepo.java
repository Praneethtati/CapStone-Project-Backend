package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface Userrepo extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.email=?1")
	public User findbyEmail(String email);

}
