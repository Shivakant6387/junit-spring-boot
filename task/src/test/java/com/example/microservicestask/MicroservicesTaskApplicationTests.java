package com.example.microservicestask;

import com.example.microservicestask.model.User;
import com.example.microservicestask.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroservicesTaskApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void getAllUsersTest() {
	Assertions.assertNotNull(userService.getAllUser());
	}

	@Test
	void createUserTest(){
		User user= new User();
		Assertions.assertNotNull(userService.createUser(user));
	}
	@Test
	void findByIdTest(){
		User user= userService.findById(33).get();
		Assertions.assertEquals(user,userService.findById(33).get());
	}
	@Test
	void findByIdNullTest(){
		//User user=userService.findById(56).get();
		User user=null;
	if(userService.findById(56).isPresent())
		user=userService.findById(56).get();
		Assertions.assertNull(user);
	}
	@Test
	void updateUserTest(){

	}
}
