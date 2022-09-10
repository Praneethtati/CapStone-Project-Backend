package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer> {
	@Query("Select a from Admin a where a.aemail=?1")
	public Admin findbyemail(String adminEmail);

}
