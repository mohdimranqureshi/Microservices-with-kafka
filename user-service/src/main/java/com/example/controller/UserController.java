package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(path = "/member", method  = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {

		List<User> allUsers = userService.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@RequestMapping(path = "/member", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {

		User result = userService.registerUser(user);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
