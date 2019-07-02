package com.xiaoyue.reflect.interfacepackge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	public MyInvocationHandler( Object target) {
		this.target=target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限检查");
		method.invoke(target, args);
		System.out.println("日志输出");
		return null;
	}
	 
	public ClassLoader getClassLoader() {
		return target.getClass().getClassLoader();
	}
	public Class[] getInterface() {
		return target.getClass().getInterfaces();
		
	}
}
