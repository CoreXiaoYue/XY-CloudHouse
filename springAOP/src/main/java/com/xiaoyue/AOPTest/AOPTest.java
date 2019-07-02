package com.xiaoyue.AOPTest;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaoyue.Dao.Aoptest;
import com.xiaoyue.Dao.PersonDao;
import com.xiaoyue.Dao.PersonDaoImpl;
import com.xiaoyue.bean.Person;
import com.xiaoyue.beanFactoryPoatProcessor.Custmer;
import com.xiaoyue.configFile.ConfigClass;
import com.xiaoyue.configFile.ConfigrationBeanFactoryPostProcessor;
import com.xiaoyue.jdbc.MyJDBC;
import com.xiaoyue.service.PersonService;
import com.xiaoyue.service.PersonServiceImpl;

public class AOPTest {
	// ioc容器
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationBeanFactoryPostProcessor.class);
	ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	@Test
	public void test1() throws Exception {
	
		getCompmentName();
//		Custmer custmer = (Custmer) context.getBean("custmer1");
//		System.out.println(custmer.getRemark());
//		//发布事件
//		context.publishEvent(new ApplicationListener<ApplicationEvent>() {
//
//			public void onApplicationEvent(ApplicationEvent event) {
//				System.out.println("发布通知"+event);
//				event = new ApplicationEvent("发布时间：2019.6.18") {
//				};
//			}
//		});
		MyJDBC myJDBC = (MyJDBC) ioc.getBean("myJDBC");
//		Person perosn = (Person) ioc.getBean("person");
//		System.out.println(perosn);
		myJDBC.add();
//		ComboPooledDataSource dataSource = (ComboPooledDataSource) ioc.getBean("dataSource");
//		ComboPooledDataSource connection = dataSource.getConnection();
//		System.out.println(dataSource.getUser());
//		Person person = context.getBean(Person.class);
//		System.out.println(person);
		
//		Aoptest aoptest = context.getBean(Aoptest.class);
//		aoptest.add(10, 2);
//		PersonDao personDao = context.getBean(PersonDaoImpl.class);
//		personDao.add(10, 10);
//		PersonService personService = (PersonService) context.getBean(PersonService.class);
//		personService.add(10, 10);
//		context.close();
	}

	// 获取容器中注册的组件名
	public void getCompmentName() {
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
