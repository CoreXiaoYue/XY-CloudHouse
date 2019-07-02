package com.xiaoyue.Dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
/**
 * @author 小岳
 * @version jdk12
 */
@Repository
public class PersonDaoImpl implements PersonDao{
	                                                                                                        
	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 *	年龄
	 */
	private int age;
	
	
	
	public PersonDaoImpl() {
		super();
	}


	/**
	 * @param name 姓名
	 * @param age	年龄
	 */
	public PersonDaoImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public void test(List<Integer> a,String b) {
		
	}

	/**
	 *	@param name 姓名
	 *	@param age 年龄
	 *	添加操作
	 */
	public void add(int name,int age) {//局部变量类型推断
		var a1 =20;
		var str = "sf";
		var list = new ArrayList<Integer>() ;
		test(list,str);
		var a = 12;
		System.out.println(""+(name/age));
	}
	
	/**
	 *	删除操作
	 */
	public void del() {
		System.out.println("");
	}

	/**
	 *	更新操作
	 */
	public void update() {
		System.out.println("");
	}

	public void selectById() {
		System.out.println("");
	}
	
	/**
	 * @param event 容器事件监听器
	 *	监听容器所发生事件
	 */
	@EventListener(classes= {ApplicationEvent.class})
	public void listener(ApplicationEvent event) {
		System.out.println(""+event);
	} 
	
	public static void main(String[] args) {
		System.out.println(100 + 5 +"s");
		PersonDaoImpl p = new PersonDaoImpl();
		p = null;
	}
}
