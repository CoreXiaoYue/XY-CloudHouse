package com.xiaoyue.TestClass;

public class Person extends Poople{
	private String name;

	@Override
	public String toString() {
		super.toString();
		return "Person [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("person的run方法。");
	}
	
	public int sum(int a,int b) {
		int c=a*b;
		return c;
		
	}
}
