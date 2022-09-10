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

import com.example.demo.entity.Medicine;
import com.example.demo.repo.Medicinerepo;
import com.example.demo.service.MedicineService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class MedicineController {
	
	@Autowired
	MedicineService service;
	
	@Autowired
	private Medicinerepo mrepo;
	
	@PostMapping("/addMedicine")
	public ResponseEntity<Medicine> adduser(@RequestBody Medicine m){
		
		return ResponseEntity.ok(service.addMedicine(m));
	}
	
	@GetMapping("/Getallmedicines")
	public List<Medicine> getallmed(){
		return service.getallMedicine();
	}
	
	@PutMapping("/UpdateMed")
	public ResponseEntity<Medicine> updateMed(@RequestBody Medicine m){
		
		return ResponseEntity.ok(service.updateMedicine(m));
	}
	
	@DeleteMapping("/MedDelete/{id}")
	public ResponseEntity<Boolean> deleteMed(@PathVariable int id){
		
		return ResponseEntity.ok(service.deleteMedicine(id));
	}
	
	@GetMapping("/MedById/{id}")
	public ResponseEntity<Medicine>getMedById (@PathVariable int id){
		
		return ResponseEntity.ok(service.getMedicineById(id));
	}
	
	@GetMapping("/MedByName/{name}")
	public ResponseEntity<Medicine>findbyMedName(@PathVariable String name)
	{
		Medicine med=mrepo.findbyMedname(name);
		if(med!=null)
			return ResponseEntity.ok(med);
		else
			return null;
	}
	
}
