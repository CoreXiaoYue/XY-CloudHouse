package com.xiaoyue.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest1 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("3");
		list.add("1");
		list.add("1");
		String set = list.set(2, "3");
		System.out.println(set ==list.get(2));
		String string = list.get(8);
		System.out.println(string);
		Vector<String> vector=new Vector<>();
	}

}
