package com.xiaoyue.configClass;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

import javax.management.Query;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest1 {
	
	public static void main(String[] args) {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
//	    // everything wires up across configuration classes...
////	    TransferService transferService = ctx.getBean(TransferService.class);
////	    transferService.transfer(100.00, "A123", "C456");
//	    DataSource bean = ctx.getBean(DataSource.class);
//	    System.out.println(bean);
		
//		String string1 = "asd";
//		int a1 = 1;
//		boolean flag1 = false;
//		change1(string1,a1,flag1);
//		System.out.println(a1);
//		System.out.println(flag1);
//		System.out.println(string1);
//		
//		System.out.println("======================");
//		
//		
//		String[] string2 = {"asd"};
//		int[] a2 = {1,5,2,5};
//		boolean flag2 = false;
//		change2(string2,a2,flag2);
//		System.out.println(a2[2]);
//		System.out.println(flag1);
//		System.out.println(string2[0]);
//		String string3 = "abc";
//		String string4 = "abc";
//		String string5 = new String("abc");
//		String string6 = new String("abc");
//		System.out.println(string3.equals(string4));
//		Object iiObject = 20;
//		System.out.println(string5.equals(new String("abc")));
//		if(true == true) {
//			
//		}
//		HashMap<String , Integer> map = new HashMap<String, Integer>();
//		map.put("abc", 25);
//		map.put("abc", 33);
//		System.out.println(map.size());
		
//		Person p1 = new Person("sdf", 50);
//		Person p2 = new Person("sdf", 28);
//		Person p3 = new Person("sdf", 10);
//		TreeSet<Person> list = new TreeSet<Person>();
//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
		
//		for (Person person : list) {
//			System.out.println(person);
//		}
//		new Hashtable();
		
//		String string = "bbbsaef";
//		String string1 = "abcwtwewewet";
//		System.out.println(string.hashCode() & (2*16-1));
//		System.out.println(string1.hashCode() &  (2*16-1));
//		System.out.println(10<<1);
		
		boolean isOdd = false;
		int a = 0;
		for(int i=1;i<=2;++i)
		{
			if(i%2==1)
					isOdd = true;
			else isOdd = false;
			a += i*(isOdd?1:-1);
		}
		System.out.println(a);
	}
	
	public  void change1(String string,int a,boolean f) {
		final int aasdfs =20;
		string = "pppp";
		a= 20;
		f = true;
	}
	
	public static void change2(String[] string,int[] a,boolean f) {
		string[0] = "pppp";
		a[2]= 20;
		f = true;
	}
}
