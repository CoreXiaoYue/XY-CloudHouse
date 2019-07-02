package com.xiaoyue.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapTest {

	public static void main(String[] args) throws Exception {
		var map = new LinkedHashMap<String,String>();
		map.put("小岳4","25");
		map.put("小岳3","18");
		map.put("小岳1","15");
		map.put("小岳2","34");
		map.forEach((key,val) -> System.out.println("key:"+key+",value:"+val));
		OutputStream out = new FileOutputStream("src/main/java/jdbc.properties");
		Properties p = new Properties();
		p.setProperty("address", "成都");
//		p.store(out, new String("jdbc驱动".getBytes("iso8859-1"),"utf-8"));
		p.store(out, "jdbc驱动");
		InputStream in = new FileInputStream("src/main/java/jdbc.properties");
		p.load(in);
		String name = (String) p.get("address");
		System.out.println(name);
//		var treeMap = new TreeMap<Book,String>((t1,t2) ->{ 
//			var book1 = (Book)t1;
//			var book2 = (Book)t2;
//			return book1.getBookId().length()>book2.getBookId().length()?-1: book1.getBookId().length()<book2.getBookId().length()?1:0;
//		} );
//		
//		treeMap.put(new Book("java","542151"), "dsadas");
//		treeMap.put(new Book("c++","542"), "dsfdryr");
//		System.out.println(treeMap);
//		System.out.println(treeMap.lastKey());
//		var treeMap = new TreeMap<Book,String>();
//		Book book = new Book("反对法","sdf");
//		System.out.println(book instanceof P);
//		treeMap.put(new Book("java","542151"), "dsadas");
//		treeMap.put(new Book("c++","542"), "dsfdryr");
//		System.out.println(treeMap);
//		System.out.println(treeMap.lastKey());
		var book1 = new Book("book1","vcg25j44");
		var book2 = new Book("book2","vcg25444545");
		var book3 = new Book("book3","vcg2j544");
		var book4 = new Book("book4","v");
//		var list = List.of(book1,book2,book3);//不可变集合
		var list = new ArrayList<Book>();
		list.add(book1);
		list.add(book4);
		list.add(book2);
		list.add(book3);
		System.out.println(list);
		Collections.sort(list, (t1,t2) -> {
			var b1 = (Book)t1;
			var b2 = (Book)t2;
			return b1.getBookId().length()>b2.getBookId().length()?11: b1.getBookId().length()<b2.getBookId().length()?-1:0;
		});
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}

}
class Book extends K {
	private String name;
	private String bookId;
	public Book(String name, String bookId) {
		super();
		this.name = name;
		this.bookId = bookId;
	}
	public Book() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", bookId=" + bookId + "]";
	}
//	@Override
//	public int compareTo(Book o) {
//		if(this == o) {
//			return 0;
//		}
//		if(o.getClass() == Book.class&& o!=null) {
//			var b = (Book)o;
//			return b.bookId.length()>this.bookId.length()?1:b.bookId.length()<this.bookId.length()?1:0;
//		}
//		return 0;
//	}
	
}
class P{
	public void test1(){
		
	}
}
class K extends P{
	
}