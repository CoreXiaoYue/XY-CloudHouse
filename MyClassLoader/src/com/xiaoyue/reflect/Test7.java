package com.xiaoyue.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test7 {
	public static void main(String[] args) {
		//匿名内部内的写法。
//		InterfaceTest1 proxy1 = (InterfaceTest1) Proxy.newProxyInstance(InterfaceTest1.class.getClassLoader(), new Class[] {InterfaceTest1.class}, new InvocationHandler() {
//			InvocationTest invocationTest = new InvocationTest();
//				@Override
//				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					method.invoke(invocationTest, args);
//					return null;
//				}
//			});
//			
//		System.out.println(proxy1.getClass().getName());
//		proxy1.test();
		//代理的对象
		ProxyInterface proxyTarget = new ProxyTarget();
		//在使用代理对象目标方法之前和之后添加动作，比如，检查，日志，通知方法
		Adevice advice = new MyAdevice();
		//创建handler对象，封装目标对象和通知对象。
		MyHandler myHandler = new MyHandler(proxyTarget,advice);
		//创建代理对象。
		ProxyInterface instance = getProxy(proxyTarget, advice,myHandler);
		//使用代理对象调用方法，将进入invoke方法根据传入的Method参数调用目标对象的方法。在此之前和之后可以调用Adevice对象的方法。
		instance.test();
		
	}

	private static ProxyInterface getProxy(ProxyInterface proxyTarget, Adevice advice,InvocationHandler handler) {
		ProxyInterface instance = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[] {ProxyInterface.class}, handler);
		return instance;
	}
}
