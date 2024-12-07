package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	
	
	User findByUserid(String userid);
}