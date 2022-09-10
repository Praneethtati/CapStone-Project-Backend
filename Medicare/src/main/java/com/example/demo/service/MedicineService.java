package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicine;
import com.example.demo.repo.Medicinerepo;

@Service
public class MedicineService {
	
	@Autowired
	Medicinerepo repo;
	
	public Medicine addMedicine(Medicine m) {
		
		return repo.save(m);
	}

	public List<Medicine> getallMedicine(){
		
		return repo.findAll();
	}
	
	public boolean deleteMedicine(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public Medicine updateMedicine(Medicine oldobject) {
		
		Medicine newobject=repo.findById(oldobject.getId()).orElse(null);
		
		newobject.setId(oldobject.getId());
		newobject.setName(oldobject.getName());
		newobject.setQuantity(oldobject.getQuantity());
		newobject.setMrp(oldobject.getMrp());
		newobject.setCategory(oldobject.getCategory());
		newobject.setDrug_description(oldobject.getDrug_description());
		
		return repo.save(newobject);
	}
	
	public Medicine getMedicineById(int id) {
		
		Medicine m=repo.findById(id).orElse(null);
		return m;
	}
	
	public Medicine findbymedname(Medicine med) {
		
		Medicine med1=repo.findbyMedname(med.getName());
		
		return med1;
	}
}
