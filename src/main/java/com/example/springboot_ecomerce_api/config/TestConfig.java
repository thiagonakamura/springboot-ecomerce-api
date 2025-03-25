package com.example.springboot_ecomerce_api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springboot_ecomerce_api.entities.OrderEntity;
import com.example.springboot_ecomerce_api.entities.UserEntity;
import com.example.springboot_ecomerce_api.enums.OrderStatus;
import com.example.springboot_ecomerce_api.repositories.OrderRepository;
import com.example.springboot_ecomerce_api.repositories.UserRepository;

/**
 * Configuration class for test data initialization.
 * This class runs only in the "test" profile and pre-populates the database
 */

@Configuration
@Profile("test")// Ensures this configuration is active only in the "test" profile
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository OrderRepository;
	
	//Method executed when the application starts.
	@Override
	public void run(String... args) throws Exception {
		UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
		OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
