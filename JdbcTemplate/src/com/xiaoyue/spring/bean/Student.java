package com.xiaoyue.spring.bean;

import java.sql.Date;

public class Student {
	private Integer stuId;
	private String name;
	private int age;
	private String brithday;
	public Student() {
	}
	public Student(Integer stuId, String name, int age, String brithday) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
		this.brithday = brithday;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
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
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	
}
