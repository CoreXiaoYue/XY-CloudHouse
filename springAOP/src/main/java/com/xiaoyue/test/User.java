package com.xiaoyue.test;

public class User extends Parent{
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
	public User(String name, int age) {
//		super(name);
		this.name = name;
		this.age = age;
	}
//	public User() {
//		super();
//	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	//sdfddddddddddddddddddddddddddddddddddddddddddddddddddddddddd山东分公司分公司分管供应和价格非银行机构环境
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
