package com.deloitte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.deloitte.controller.AppController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KrogerProjApplicationTests {

	@Autowired
	AppController appController;
	
	@Test
	public void AppControllerTest() {
		
		assertEquals(1,appController.verifyMyApp().getId());
		assertEquals(28, appController.verifyMyApp().getAge());
		assertEquals("asd",appController.verifyMyApp().getAddress() );
	}

}
