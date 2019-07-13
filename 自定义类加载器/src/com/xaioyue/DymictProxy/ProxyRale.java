package com.xaioyue.DymictProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyRale implements InvocationHandler{
	
	private Star raleStar;
	
	

	public ProxyRale(Star raleStar) {
		super();
		this.raleStar = raleStar;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("+++++");
		method.invoke(raleStar, args);
//		System.out.println(method.getName());
		return null;
	}

}
