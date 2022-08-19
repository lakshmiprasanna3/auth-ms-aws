package com.cognizant.ms.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.cognizant.ms.exception.UserNotFound;
import com.cognizant.ms.model.User;
import com.cognizant.ms.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);


	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			LOGGER.info("STARTED - loadUserByUsername");
			User user = userRepository.findByUserName(username);
			LOGGER.info("END - loadUserByUsername");
			
			
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					new ArrayList<>());
			
			}catch(Exception e)
			{
				LOGGER.error("ERROR-username not found");
				throw new UserNotFound("User by the given username not found");
			}
		

	}

}
