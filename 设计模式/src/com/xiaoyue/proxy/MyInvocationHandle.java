package com.xiaoyue.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler {
	Object target;
	
	public MyInvocationHandle(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Advice advice = new Advice();
		advice.postAdvice(method);
		method.invoke(target, args);
		
		advice.afterAdvice(method);
		return null;
	}

}
