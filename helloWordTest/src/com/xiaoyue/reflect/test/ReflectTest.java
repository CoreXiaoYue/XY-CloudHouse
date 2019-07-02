package com.xiaoyue.reflect.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

import com.xiaoyue.TestClass.Person;

	/*
	 * 
	 * 	
	 * 通过反射技术调用没有参数的方法
	 * */
	public class ReflectTest {
	public static void invokeMethed(String file,String methedName) throws Exception {
		BufferedReader bf=new BufferedReader(new FileReader(file));
		String className = bf.readLine();
		Class<?> clazz = Class.forName(className);
		Object p = clazz.newInstance();
		Method method = clazz.getMethod(methedName);
		method.invoke(p);
	}

	/*
	 * 通过反射调用带两个int参数的方法
	 */
	public static int invokeMethedArg(String file,String methedName,int agrs1,int args2) throws Exception {
		BufferedReader bf=new BufferedReader(new FileReader(file));
		String className = bf.readLine();
		Class<?> clazz = Class.forName(className);
		Object p = clazz.newInstance();
		Method method = clazz.getMethod(methedName,int.class,int.class);
		int i = (int) method.invoke(p,agrs1,args2);
		return i;
	}

	public static void main(String[] args) throws Exception {
//		Class<?> clazz = Class.forName("com.xiaoyue.TestClass.Person");
//		Person p = (Person) clazz.newInstance();
//		Method method = clazz.getMethod("run");
//		method.invoke(p);
		
		invokeMethed("src/config.properties","run");
		
		int invokeMethedArg = invokeMethedArg("src/config.properties","sum", 2, 3);
		System.out.println(invokeMethedArg);
		

	}
}
