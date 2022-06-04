package com.shoe.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.demo.entity.Userlist;
@Repository
public interface UserRepo extends JpaRepository<Userlist, Integer> {

	
	
	

}
