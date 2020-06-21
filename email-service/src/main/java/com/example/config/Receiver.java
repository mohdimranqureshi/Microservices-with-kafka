package com.example.config;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.exampe.dto.UserDTO;
import com.example.service.EmailService;

public class Receiver {
	
	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	@Autowired
	EmailService emailService;
	
	@KafkaListener(topics = "${spring.kafka.topic.userCreated}")
	public void receive(UserDTO obj) {
		logger.info("received payload" +obj);
		emailService.sendEmail(obj);
		latch.countDown();
	}
}
