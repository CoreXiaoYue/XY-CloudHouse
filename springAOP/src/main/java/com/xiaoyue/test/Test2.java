package com.xiaoyue.test;

public class Test2 {
	public Test2() {
		test12();
	}
	public int s;//非静态变量不能在静态方法中直接访问，包括main方法
	public static void main(String[] args) {
//		System.out.println(s);
		final int o;
		o =15;
		System.out.println(o);
		int i = Integer.parseInt("5");//将字符串转成int值
		System.out.println(i == 5);
		boolean b = Boolean.parseBoolean("true");//将字符串转成布尔值
		Boolean boolean1 = Boolean.valueOf("false");
		String valueOf = String.valueOf(b);//将布尔值转换成字符串
		System.out.println(valueOf+"---");
		System.out.println(boolean1);
		System.out.println(b);
		Integer in = 20;
		byte by1 = 20;
		int v = by1;
		System.out.println(v);
		int by2 = 15;
		byte x = (byte) by2;
		System.out.println(x);
		 System.out.println(100%3.0);
		 String str11 = new String("cvcv");
		 String str12 ="cvcv";
		 System.out.println(str11==str12);
		 short a = 128;
		 byte b12 = (byte) a;
		 System.out.println(b12);//-128
		 StringBuffer sub = new StringBuffer();
		 int int1 = 1;
		 float f1 = 2;
		 System.out.println(int1/f1);
		 Thread t = new Thread();
	}
	public void test12() {
		System.out.println(s);
	}
}
class A{
	A(){
		
	}
	A(String str){
		
	}
}
class B extends A{
	B(){
	}
}