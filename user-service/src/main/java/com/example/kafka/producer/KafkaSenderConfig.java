package com.example.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaSenderConfig {

	@Value("${spring.kafka.bootstrap-server}")
	private String bootstrapServer;
	
	@Bean
	public Map<String, Object> producerConfig(){
		
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return props;
	}
	
	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		return new DefaultKafkaProducerFactory<String, Object>(producerConfig());
	}
	
	@Bean
	KafkaTemplate<String, Object> kafkaTemplate(){
		return new KafkaTemplate<String, Object>((ProducerFactory<String, Object>) producerConfig());
	}
	
	@Bean
	public Sender sender() {
		
		return new Sender();
	}
}
