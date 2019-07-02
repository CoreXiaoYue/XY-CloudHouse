package com.xiaoyue.reflect.test;

import java.lang.reflect.Proxy;

import com.xiaoyue.reflect.interfaceImpl.PersonImpl;
import com.xiaoyue.reflect.interfacepackge.MyInvocationHandler;
import com.xiaoyue.reflect.interfacepackge.Person;

public class ProxyTest {
	public static void main(String[] args) {
		Person person=new PersonImpl();
		System.out.println(person);
		person.add();
		person.delete();
		System.out.println("-----------------------------");
		MyInvocationHandler m=new MyInvocationHandler(person);
		System.out.println(m);
		Person p = (Person) Proxy.newProxyInstance(m.getClassLoader(), m.getInterface(), m);
		p.add();
		p.delete();
	
	}

}
