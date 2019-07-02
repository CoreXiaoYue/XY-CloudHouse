package com.xiaoyue.io.SequenceInputStream;

import java.io.Serializable;

public class Person  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameString;
	private int age;
	private String address;
	public Person(String nameString, int age, String address) {
		super();
		this.nameString = nameString;
		this.age = age;
		this.address = address;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [nameString=" + nameString + ", age=" + age + ", address=" + address + "]";
	}
	public Person() {
		super();
	}
	

}
