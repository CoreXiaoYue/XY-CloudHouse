package com.xiaoyue.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MapTest1 {
	public static int staticVar = 0; 
	 public int instanceVar = 0; 
	 public MapTest1 () 
	 { 
	 staticVar++; 
	 instanceVar++; 
	 System.out.println("staticVar=" + staticVar + ",instanceVar=" + instanceVar); 
	 } 
	 
	 public static Long Test2() {
		
		return Math.round(-22.3);
	 } 
	 public void Test3() {
		 
	 }
	 public static void main(String[] args) {
		 MapTest1 test1=new MapTest1();
		 MapTest1 test2=new MapTest1();
		 MapTest1 test3=new MapTest1();
		 System.out.println(MapTest1.Test2());
		 
		 System.out.println("--------------HashMap-------------");
		 Map<Integer, String> map1=new HashMap<Integer, String>();
		 map1.put(1, "小岳");
		 map1.put(2, "崇君");
		 map1.put(3, "兴虎");
		 boolean containsValue = map1.containsValue("兴虎1");
		 System.out.println(containsValue);
		 Set<Entry<Integer,String>> entrySet = map1.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			System.out.println("键："+next.getKey()+",值："+next.getValue());
		}
		
		System.out.println("--------------HashSet-------------");
		Set<Integer> keySet = map1.keySet();
		Iterator<Integer> iterator2 = keySet.iterator();
		while(iterator2.hasNext()) {
			Integer next = iterator2.next();
			System.out.println("键："+next+"值："+map1.get(next));
		}
		
		System.out.println("----------LinkedHashMap----------");
		HashMap<Integer, String> map2=new LinkedHashMap<Integer, String>();//重复键，值覆盖。
		map2.put(1, "阿朵");
		map2.put(2, "珊珊");
		map2.put(3, "阿龙");
		System.out.println(map2.size());
		boolean containsKey = map2.containsKey(1);
		System.out.println(containsKey);
		
		System.out.println("--------------HashSet-------------");
		Set set1=new HashSet<String>();//不允许重复值。
		String string="123";
		set1.add(string);
		set1.add(string);
		set1.add("set3");
		Iterator iterator3 = set1.iterator();
		while(iterator3.hasNext()) {
			Object next = iterator3.next();
			System.out.println(next);
		}
		System.out.println(set1.size());
		
		
	}
}
