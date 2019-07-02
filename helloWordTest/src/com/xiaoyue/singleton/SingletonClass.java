package com.xiaoyue.singleton;

public class SingletonClass {
	private static final SingletonClass SINGLETON1=new SingletonClass();
	private static final SingletonClass SINGLETON2=new SingletonClass();
	private static final SingletonClass SINGLETON3=new SingletonClass();
	
	//私有构造器
	private SingletonClass() {
		
	}
	
	public void test() {
		System.out.println("123");
	}
	
	public static SingletonClass getSingletonClass(String string) {
		if(string=="singleton") {
			return SINGLETON1;
		}else if(string=="singleton2"){
			return SINGLETON2;
		}else {
			return SINGLETON3;
		}
	}

}
