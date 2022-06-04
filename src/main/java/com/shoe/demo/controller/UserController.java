package com.shoe.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoe.demo.entity.Products;
import com.shoe.demo.service.ProductsService;

  @Controller
public class UserController {
	  @Autowired
	  private ProductsService service;
	@GetMapping("/display")
		public String Display(Model m) {
			List<Products> pro1=service.getAllPro();
			m.addAttribute("pro1",pro1);
		return"display";
	}
	@GetMapping("/payment")
	public String addAddress(HttpSession session)
	{
		session.setAttribute("msg", "***** Congrtulations Payment went Sucessfull*****");
		return"redirect:/display";
	}

}
