package com.xiaoyue.struts2.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	@Autowired(required=false)
	private Book book;
	public Person(Integer id, String name, Integer age, String address,
			Book book) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.book = book;
	}
	public Person() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", address=" + address + ", book=" + book + "]";
	}
	

}
