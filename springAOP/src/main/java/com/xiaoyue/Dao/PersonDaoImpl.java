package com.xiaoyue.Dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
/**
 * @author С��
 * @version jdk12
 */
@Repository
public class PersonDaoImpl implements PersonDao{
	                                                                                                        
	
	/**
	 * ����
	 */
	private String name;
	/**
	 *	����
	 */
	private int age;
	
	
	
	public PersonDaoImpl() {
		super();
	}


	/**
	 * @param name ����
	 * @param age	����
	 */
	public PersonDaoImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public void test(List<Integer> a,String b) {
		
	}

	/**
	 *	@param name ����
	 *	@param age ����
	 *	��Ӳ���
	 */
	public void add(int name,int age) {//�ֲ����������ƶ�
		var a1 =20;
		var str = "sf";
		var list = new ArrayList<Integer>() ;
		test(list,str);
		var a = 12;
		System.out.println(""+(name/age));
	}
	
	/**
	 *	ɾ������
	 */
	public void del() {
		System.out.println("");
	}

	/**
	 *	���²���
	 */
	public void update() {
		System.out.println("");
	}

	public void selectById() {
		System.out.println("");
	}
	
	/**
	 * @param event �����¼�������
	 *	���������������¼�
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
