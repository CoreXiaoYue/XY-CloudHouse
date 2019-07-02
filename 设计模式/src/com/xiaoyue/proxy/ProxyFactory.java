package com.xiaoyue.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object getProxy(Object target) {
		MyInvocationHandle myInvocationHandle = new MyInvocationHandle(target);
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInvocationHandle);
		
	}
}
