package com.shoe.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.shoe.demo.entity.Products;
import com.shoe.demo.entity.Userlist;
import com.shoe.demo.service.ProductsService;
import com.shoe.demo.service.UserService;



@Controller
public class AdminController {
	@Autowired
	private ProductsService service;
	@Autowired
	private UserService uservice;
	
	@GetMapping("/home")
	public String home(Model m) {
		
		List<Products> pro=service.getAllPro();
		m.addAttribute("pro",pro);
		return"home";
	}
	@GetMapping("/user")
	public String user(Model n) {
		List<Userlist> use=uservice.getAlluser();
		n.addAttribute("use",use);
		return"user";
	}
	@GetMapping("/addProduct")
	public String AddProducs() {
		System.out.println("add");
		
		return "addProduct";
	}
	@PostMapping("/save")
	public String saveproducts(@ModelAttribute Products p,HttpSession session) {
		
		service.addproduct(p);
		session.setAttribute("msg", "****Product Details are added Sucessfully****");
		return "redirect:/home";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Products e = service.getProById(id);
		m.addAttribute("pro", e);
		return "edit";
	}
	@PostMapping("/update")
	public String updatepro(@ModelAttribute Products p,HttpSession session) {
		
		service.addproduct(p);
		session.setAttribute("msg", "****Product Details are upadted Sucessfully****");
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpSession session ) {
	
		service.deletePro(id);
	
		return "redirect:/home";

}
}