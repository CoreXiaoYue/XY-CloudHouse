package com.xiaoyue.hashSet;

import java.util.HashMap;
import java.util.TreeSet;

public class MyHashSet<T> {
	HashMap<T, Object> map;
	private static final Object PRESENT = new Object();

	public MyHashSet() {
		map = new HashMap<T, Object>();
	}

	public void put(T object) {
		map.put(object, PRESENT);
	}

	public int size() {
		return map.size();
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (T key : map.keySet()) {
			sBuilder.append(key + ",");
		}
		sBuilder.setCharAt(sBuilder.length() - 1, ']');
		return sBuilder.toString();

	}

	public static void main(String[] args) {
		MyHashSet<Integer> set = new MyHashSet<Integer>();
//		set.put(8);
//		set.put(3);
//		set.put(2);
//		set.put(5);
//		System.out.println(set.toString());
//		System.out.println(set.size());

//		MyHashSet<Employee> empSet = new MyHashSet<Employee>();
//		empSet.put(new Employee(1, "小岳", 5000));
//		empSet.put(new Employee(7, "小海", 15000));
//		empSet.put(new Employee(3, "小海", 3500));
//		empSet.put(new Employee(6, "小军", 8000));
//		System.out.println(empSet);
//		System.out.println(empSet.size());

//		TreeMap<Employee, String> treeMap = new TreeMap<Employee, String>();
//		treeMap.put(new Employee(1, "小岳", 5000), "ff");
//		treeMap.put(new Employee(5, "小海", 15000), "bb");
//		treeMap.put(new Employee(3, "小海", 8000), "kk");
//		treeMap.put(new Employee(8, "小军", 5000), "oo");
//		System.out.println(treeMap);
		
		TreeSet<Employee> treeSet = new TreeSet<Employee>();
		treeSet.add(new Employee(1, "小岳", 5000));
		treeSet.add(new Employee(5, "小海", 15000));
		treeSet.add(new Employee(3, "小海", 8000));
		treeSet.add(new Employee(8, "小军", 5000));
		System.out.println(treeSet);
		for (Employee employee : treeSet) {
			System.out.println(employee);
		}
		
	}

}

class Employee implements Comparable<Employee> {
	Integer id;
	String name;
	double salary;

	public Employee(Integer id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]"+"\n";
	}

	@Override
	public int compareTo(Employee o) {
		if (this.salary > o.salary) {
			return 1;
		} else if (this.salary < o.salary) {
			return -1;
		} else {
			if (this.id > o.id) {
				return 1;
			} else if (this.id < o.id) {
				return -1;
			} else {
				return 0;
			}
		}

	}

}
