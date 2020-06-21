package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.kafka.producer.Sender;
import com.example.model.User;
import com.example.repository.UserRepository;

@Component
public class UserService implements UserInterface {

	@Value("${spring.kafka.topic.userCreated}")
	private String USER_CREATED_TOPIC;

	@Autowired
	UserRepository userRepository;

	private Sender sender;

	@Override
	public User registerUser(User inputValue) {

		User result = userRepository.save(inputValue);
		sender.send(USER_CREATED_TOPIC, result);
		return result;
	}

	@Override
	public List<User> findAll() {

		List<User> result = (List<User>) userRepository.findAll();
		return result;
	}

}
