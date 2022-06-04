package com.shoe.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoe.demo.entity.Products;
import com.shoe.demo.entity.Userlist;
import com.shoe.demo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService service;
	
	@GetMapping("/index")
	public String Login()
	{
	return"redirect:/display";	
	}
	@GetMapping("/register")
	public String Register() {
		return"register";
	}
	@PostMapping("/saveu")
	public String SaveUser(@ModelAttribute Userlist u, HttpSession session) {
		service.saveUser(u);
		session.setAttribute("msg", "****Congratulations! Registered Sucessfully.Please Login now****");
		return"welcome";
	}

	

}
