package com.shoe.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoe.demo.entity.Products;
import com.shoe.demo.repo.ProductsRepo;
@Service
public class ProductsService {
	@Autowired
	private ProductsRepo repo;
	
	public void addproduct(Products p) {
		repo.save(p);
	}
	
	public List<Products> getAllPro(){
		return repo.findAll();
	}
	
	public Products getProById(int id) {
		Optional<Products> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deletePro(int id) {
		repo.deleteById(id);
	}

}
