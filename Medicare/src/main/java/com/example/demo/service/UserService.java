package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.Userrepo;

@Service
public class UserService {
	
	@Autowired
	Userrepo repo;
	
	public User addUser(User u)
	{
		return repo.save(u);
	}
	
	
	
	public List<User> getAllUser()
	{
		return repo.findAll();
	}
	
	
	
	public User getUserById(int id) {
		
		User u=repo.findById(id).orElse(null);
	    return u;
    }
	
	
	public User updateUser(User olduser)
	{
		User newuser=repo.findById(olduser.getId()).orElse(null);
		
		newuser.setId(olduser.getId());
		newuser.setName(olduser.getName());
		newuser.setPhno(olduser.getPhno());
		newuser.setEmail(olduser.getPhno());
		newuser.setPassword(olduser.getPassword());
		
		return repo.save(newuser);
	}
	
	
	public boolean deleteUser(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
	public User login(User u) {
		User uu=repo.findbyEmail(u.getEmail());
		
		if(uu.getPassword().equals(u.getPassword()))
		{
			return uu;
		}
		
		return null;
	}
	

}

