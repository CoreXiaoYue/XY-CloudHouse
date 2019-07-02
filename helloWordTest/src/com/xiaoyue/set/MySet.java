package com.xiaoyue.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MySet {

	public static void main(String[] args) {
		Set<?> set = new HashSet<String>();
		System.out.println(16>>>1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "小岳");
		System.out.println(1<<30);
		System.out.println();
		Collection<String> values = map.values();
		Iterator<String> iterator = values.iterator();
		if(iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string);
		}
		
		
	}

}
