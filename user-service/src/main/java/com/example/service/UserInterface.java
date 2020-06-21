package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserInterface {
	
	User registerUser(User inputValue);
	
	List<User> findAll();
}
