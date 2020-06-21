package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
	
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public void send(String topic, Object payload) {
		logger.info("Sending Payload" +payload+ "to Topic" +topic);
		kafkaTemplate.send(topic, payload);
	}
}
