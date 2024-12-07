package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.User;
import com.example.hotel.repository.UserRepository;



@Service
public class LoginService {

	
	
	@Autowired
    private UserRepository userRepository;

    public List<User> getAllLogins() {
        return userRepository.findAll();
    }
}