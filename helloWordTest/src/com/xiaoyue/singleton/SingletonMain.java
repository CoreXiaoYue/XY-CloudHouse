package com.xiaoyue.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		    SingletonClass singleton2 = SingletonClass.getSingletonClass("singleton1");
		    
			SingletonClass singleton1 = SingletonClass.getSingletonClass("singleton2");
			System.out.println(singleton1);
			System.out.println(singleton2);
			System.out.println(singleton1);
			System.out.println(singleton2);
	}

}
