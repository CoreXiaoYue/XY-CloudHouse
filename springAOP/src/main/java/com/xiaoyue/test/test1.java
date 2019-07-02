package com.xiaoyue.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class test1 {

	
	static int arr[] = new int[5];
	public static test1 test2 = new test1();
	{
		System.out.println("¥˙¬ÎøÈ");
	}
	static {
		System.out.println("æ≤Ã¨”Ôæ‰øÈ");
	}

	static String str6="0123456789";
	static int a = 20;
	public test1() {
		test2();
	}
	
	public static void main(String[] args) {
		System.out.println(2%2+"2%2");
		System.out.println(arr.length);
		int i=0;
		int j=0;
		if((++i>0)||(++j>0))
		{
		System.out.println("i="+i+"j="+j);
		}
		System.out.println(arr[0]);
		User user = new User("–°‘¿",25);
		test1 test1 = new test1();
		Integer in = 127;
		Integer in1 = 127;
		System.out.println(in == in1);
//		System.out.println(args[0]);
		 byte b = (byte)129;
		 System.out.println();
		 char[] ch = {'a','b','c'};
		System.out.println(str6.substring(5));
		String str1 = new String("str1");
		String str2 = "str2";
//		User user = new User("–°‘¿",25);
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		map.put("aaa", 1);
//		map.put("bbb", 2);
//		test(str1,str2,user,map,ch);
		System.out.println(str1);
		System.out.println(str2);
//		System.out.println(user);
//		System.out.println(map);
		System.out.println(ch);
		String s ="hh";
		String c = "h";
		String v = "h";
		System.out.println((c+v) == s);
		Properties p = new Properties();
		System.out.println(returnTest());
	}
//	public static void test(String str,String str2,User user,Map<String,Integer> map,char[] ch) {
//		a =15;
//		str = new String("str11");
////		str = "str11";
//		str2 = "str22";
////		user = new User("¥Û…Ω",66);
////		map.remove("aaa");
//		map.put("aaa", 3);
//		ch[1] = 'g';
//	}
	public void test2() {
		
	}
	public static boolean returnTest()
	{
	    try
	    {
	        return true;
	    }
	    catch (Exception e)
	    {
	 
	    }
	    finally
	    {
	        return false;
	    }
	}

}
