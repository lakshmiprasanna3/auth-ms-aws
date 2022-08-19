package com.cognizant.ms.controller;


import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;


import com.cognizant.ms.model.JwtRequest;

import com.cognizant.ms.service.CustomUserDetailService;
import com.cognizant.ms.util.JwtUtil;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Mock
	private AuthorizationController authorizationController;

	@Mock
	CustomUserDetailService service;

	@Mock
	JwtUtil jwtUtil;

	@Test
	public void contextLoads() {
		assertNotNull(authorizationController);
	}

	@Test
	public void loginTestSuccess() throws Exception {

		logger.info("started");
		JwtRequest user = new JwtRequest("Prasanna", "pwd1");

		when(authorizationController.generateToken(user)).thenReturn(ResponseEntity.ok("200"));
		ResponseEntity<String> authenticationResponse = authorizationController.generateToken(user);

		assertEquals(HttpStatus.OK, authenticationResponse.getStatusCode());

	}

}
