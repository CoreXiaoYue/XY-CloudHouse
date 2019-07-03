package com.xiaoyue.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import com.xiaoyue.web.serviceImpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserServiceTest {
	@Autowired
	UserServiceImpl userService;
	
	@Test
	public void testUserService() {
		System.out.println(userService);
	}
}
