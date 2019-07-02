package com.xiaoyue.io.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler{
	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = startTime();
		method.invoke(target, args);
		long endTime = endTime();
		System.out.println("程序共花费"+(endTime-startTime)+"毫秒");
		return null;
	}

	
	public  long startTime() {
		Long startTime=System.currentTimeMillis();
		return startTime;
	}
	public long endTime() {
		Long endTime=System.currentTimeMillis();
		return endTime;
	}
	
	
	 
	public ClassLoader getClassLoader() {
		return target.getClass().getClassLoader();
	}
	public Class[] getInterface() {
		return target.getClass().getInterfaces();
		
	}
	
	
	
}
