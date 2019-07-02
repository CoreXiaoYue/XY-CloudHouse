package com.xiaoyue.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		People stuPeople = new Student();//创建目标类
//		MyInvocationHandle myInvocationHandle = new MyInvocationHandle(stuPeople);//
//		People people = (People) Proxy.newProxyInstance(stuPeople.getClass().getClassLoader(), 
//						stuPeople.getClass().getInterfaces(),
//						myInvocationHandle);
//		people.study();
		//使用代理工厂类创建代理类。
		People people = (People) ProxyFactory.getProxy(stuPeople);
		people.study();
	}
}
