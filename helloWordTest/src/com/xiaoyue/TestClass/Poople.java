package com.xiaoyue.TestClass;

public class Poople {
	
	private String name;
	public  Poople() {
		System.out.println("父类");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("123");
	}

	@Override
	public String toString() {
		return "Poople [name=" + name + "]";
	}


}
