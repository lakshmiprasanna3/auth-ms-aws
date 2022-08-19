package com.cognizant.ms.service;


import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.core.userdetails.UserDetails;


import com.cognizant.ms.repository.UserRepository;

@SpringBootTest
class AuthServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
	private UserRepository userRepository;

	@Mock
	private CustomUserDetailService service;

	
	
	@Test
	void customUserDetailsServiceNotNullTest() {
		assertThat(service).isNotNull();
	}

	@Test
	public void loadUserByUserNameTest() {

		logger.info("started");
		UserDetails userDetails = new org.springframework.security.core.userdetails.User("Prasanna","pwd1",new ArrayList<>());
		when(service.loadUserByUsername("Prasanna")).thenReturn(userDetails);
		assertThat(service.loadUserByUsername("Prasanna")).isNotNull();
		assertEquals(service.loadUserByUsername("Prasanna"),userDetails);
	}

}
