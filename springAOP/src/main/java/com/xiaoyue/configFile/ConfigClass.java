package com.xiaoyue.configFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.xiaoyue.Dao.Aoptest;
import com.xiaoyue.Dao.PersonDao;
import com.xiaoyue.Dao.PersonDaoImpl;
import com.xiaoyue.bean.Person;
import com.xiaoyue.beanAOP.PointAOP;
@ComponentScan(value= {"com.xiaoyue"})
@EnableAspectJAutoProxy()
@Configuration
public class ConfigClass {
	
//	@Bean
//	public PersonDaoImpl personDaoImpl() {
//		return new PersonDaoImpl();
//	}
	
	@Bean
	public Aoptest Aoptest() {
		return new Aoptest();
	}
	
	@Bean
	public PointAOP pointAOP() {
		return new PointAOP();
	}
	
	@Bean
	public Person person() {
		return new Person();
	}
}
