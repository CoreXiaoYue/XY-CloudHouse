package com.xiaoyue.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test7 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入字符串。");
//		String nextLine = scanner.nextLine();
//		var list = new ArrayList<String>();
//		String[] splitString = nextLine.split(",");
//		for (int i = 0; i < splitString.length; i++) {
//			list.add(splitString[i]);
//		}
//		System.out.println(list);
//		System.out.println(list.indexOf("html"));
		System.out.println("-------------------");
		String[] str = {"a","b","c","d","a","f","b","h","a"};
		HashMap<String,Integer> temp = new HashMap<String,Integer>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < str.length; i++) {
			if(map.size()!=0) {
				Set<String> keySet = map.keySet();
				Iterator<String> keyIterator = keySet.iterator();
				while(keyIterator.hasNext()) {
					int count = 0;
					String next = keyIterator.next();
					if(next.equals(str[i])) {
						count++;
					}
					temp.put(str[i], count);
					
				}
			}
			map.put(str[i], i);
			
		}
		System.out.println(map.size()+":"+temp.size());
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String next = keyIterator.next();
			System.out.println("key:"+next+",value:"+map.get(next));
		}
		
		try {
			System.out.println(10/0);
			String strdsdf = args[10];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("数组下标越界");
			e.printStackTrace();
		}catch (ArithmeticException e) {
			System.out.println("格式错误");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===============");
		Set<String> temp1 = temp.keySet();
		Iterator<String> keyIterator1 = temp1.iterator();
		while(keyIterator1.hasNext()) {
			String next = keyIterator1.next();
			System.out.println("key:"+next+",value:"+map.get(next));
		}
	}
public void test() {
	int a = 10;
}
}
