package com.xiaoyue.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test6 {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("小岳");
		list.add("dsf");
		list.add("uyityu");
		list.add("规划局");
		list.forEach(str -> System.out.println(str));
		
		Set<String> set = new HashSet();
		set.add("小岳");
		set.add("dsf");
		set.add("uyityu");
		set.add("规划局");
		set.forEach(str -> System.out.println(str));
	}

}
