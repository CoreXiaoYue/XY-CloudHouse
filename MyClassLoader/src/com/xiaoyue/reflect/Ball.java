package com.xiaoyue.reflect;

public class Ball {
	private String str1 = "ballbb";
	public String str2 = "baskeball";
	
	@Override
	public String toString() {
		return "Ball [str1=" + str1 + ", str2=" + str2 + "]";
	}
	
	public void test1() {
		System.out.println("通过反射调用方法");
	}
	public String test2(int a,int b) {
		return "a+b="+(a+b);
	}

	
}
