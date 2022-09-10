package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Medicine;

public interface Medicinerepo extends JpaRepository<Medicine, Integer> {
	
	@Query("Select m from Medicine m where m.name=?1")
	public Medicine findbyMedname(String medname); 

}
