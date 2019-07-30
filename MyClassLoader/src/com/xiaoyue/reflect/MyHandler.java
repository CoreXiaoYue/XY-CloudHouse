package com.xiaoyue.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	private ProxyInterface target;
	private Adevice adevice; 
	


	public MyHandler(ProxyInterface target, Adevice adevice) {
		super();
		this.target = target;
		this.adevice = adevice;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		adevice.before(method);
		Object invoke = method.invoke(target, args);
		adevice.after(method);
		return invoke;
	}

}
