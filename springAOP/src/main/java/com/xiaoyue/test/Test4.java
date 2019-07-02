package com.xiaoyue.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Test4 {
	int a = 12;
	static Integer[] s1;
	public static void main(String[] args) throws Exception {
//		int[] i = {2,5,6,53,5,62};
//		System.out.println(Arrays.binarySearch(i, 6));
//		List<int[]> asList = Arrays.asList(i);
//		Iterator<int[]> iterator = asList.iterator();
//		StringBuilder bu = new StringBuilder();
		
//		new Thread(() -> {
//			for (int j = 0; j < 10; j++) {
//				System.out.println(j);
//			}
//			
//		}).start();
		
		int[] in = {2,9,6,56,3,4};
		int[] clone = new int[20] ;
		int[] s;
		clone= in.clone();
		System.out.println(clone.length);
//		System.out.println(s.length);
		System.out.println(Objects.toString(s1));
		System.out.println(Arrays.toString(clone));
		byte[] by = {'s','d','g','t','g','f','g','l'};
		String string = new String(by,"utf-8");
		System.out.println(string);
		StringBuilder b = new StringBuilder();
		
		b.append("asdas");
		b.append("asdas");
		b.append("asdas11111");
		b.append("asdas11111");
		b.append("asdas");
		System.out.println(b.length());
		System.out.println(b.capacity());
	}
	public static void test() {
//		a = 30;//静态方法不能使用非静态变量
	}

}
