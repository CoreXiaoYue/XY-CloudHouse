package com.xiaoyue.bean;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//@Lazy(true)
@Component
public class Person implements InitializingBean,DisposableBean{
	private Double doubles;
	private Integer ages;
	@Value("小山")
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化完成");
		if(this.name == null) {
			throw new IllegalStateException("name没有赋值");
		}
	}
	public void destroy() throws Exception {
		System.out.println("perosn对象销毁");
	}
	@PostConstruct
	public void init() {
		System.out.println("初始化perosn--init");
	}
	@PreDestroy
	public void destory() {
		System.out.println("初始化结束perosn--init");
	}
	

}
