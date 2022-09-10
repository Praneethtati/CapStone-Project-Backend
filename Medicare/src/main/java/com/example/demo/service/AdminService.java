package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repo.Adminrepo;

@Service
public class AdminService {

	@Autowired
	Adminrepo repo;
	
	public Admin adminInsert(Admin a)
	{
		return repo.save(a);
				
	}
	
	public Admin adminLogin(Admin oldobject) {
		Admin newobject=repo.findbyemail(oldobject.getAemail());
		if(newobject.getApassword().equals(oldobject.getApassword()))
		{
			return newobject;
		}
		else {
		return null;
		}
	}
	
	
}
