package com.shoe.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.demo.entity.Products;
@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{

}
