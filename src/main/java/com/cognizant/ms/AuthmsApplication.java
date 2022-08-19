package com.cognizant.ms;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cognizant.ms.model.User;
import com.cognizant.ms.repository.UserRepository;



@SpringBootApplication
@EnableFeignClients
public class AuthmsApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(AuthmsApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(101, "Prasanna", "pwd1");
		User user2 = new User(102, "Lakshmi", "pwd2");
		userRepository.save(user1);
		userRepository.save(user2);
	}

}
