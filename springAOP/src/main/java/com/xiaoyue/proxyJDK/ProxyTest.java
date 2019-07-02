package com.xiaoyue.proxyJDK;

import java.lang.reflect.Proxy;


import com.xiaoyue.service.PersonService;
import com.xiaoyue.service.PersonServiceImpl;

public class ProxyTest {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
//		PersonServiceImpl personService = (PersonServiceImpl) context.getBean("personServiceImpl");
		PersonServiceImpl personService = new PersonServiceImpl();
		GetAdvicer getAdvicer = new GetAdvicer(new String[] {"com.xiaoyue.service.PersonServiceImpl.add(..)","com.xiaoyue.service.PersonServiceImpl.update(..)"});
		MyHandler myHandler = new MyHandler(personService,getAdvicer);
		PersonService instance = (PersonService) Proxy.newProxyInstance(PersonService.class.getClassLoader(), new Class[] {PersonService.class}, myHandler);
		instance.add(10, 5);
		instance.del();
		instance.update();
	}

}
