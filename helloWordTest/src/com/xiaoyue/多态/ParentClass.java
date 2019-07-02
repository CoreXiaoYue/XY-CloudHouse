package com.xiaoyue.多态;

public class ParentClass {
	protected void test1() {
		
	}
}

class Child extends ParentClass {

	@Override
	public void test1() {
//		super.test1();
		System.out.println("子类重写父类方法");
	}
	
}