package com.xiaoyue.configClass;

public class Person implements Comparable<Person>{
	
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


	public int compareTo(Person o) {
		
		if(this.age - o.getAge()>0) {
			return 1;
		}
		if(this.age == o.getAge()) {
			return 0;
		}
		
		return -1;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	

}
