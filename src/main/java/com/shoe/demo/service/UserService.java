package com.shoe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoe.demo.entity.Products;
import com.shoe.demo.entity.Userlist;
import com.shoe.demo.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo rep;
	
	public void saveUser(Userlist u) {
		rep.save(u);
	}
	public List<Userlist> getAlluser(){
		return rep.findAll();
	}
}
