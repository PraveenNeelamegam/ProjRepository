package com.deloitte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.controller.WelcomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeServiceApplicationTests {

	@Autowired
	WelcomeController welcomeController;
	
	@Test
	public void WelcomeControllerTest() {
		assertEquals("Welcome To Deloitte From Port null",welcomeController.welcome());
		
	}

}
