package com.cognizant.ms.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AuthModelTest {

	


	@Test
	void noArgsUserNotNullTest() {
		assertThat(new User()).isNotNull();
	}
	
	@Test
	void AllArgsUserTest() {
		User user = new User(1, "Prasanna", "pwd1") ;
		assertNotNull(user) ;
	}

	
	@Test
	void userSetterTest() {
		User u = new User();
		u.setUserName("Prasanna");
		u.setPassword("pwd1");
		assertThat(assertThat(u).isNotNull());
	}
	
	
	@Test
	void userGetterTest() {
		User u = new User(1,"Prasanna","pwd1");
		assertEquals("Prasanna", u.getUserName()) ;
		assertEquals("pwd1", u.getPassword());
	}
	
	
	
	
	
}
