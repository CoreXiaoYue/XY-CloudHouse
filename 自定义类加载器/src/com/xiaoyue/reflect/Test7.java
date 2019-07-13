package com.xiaoyue.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test7 {
	public static void main(String[] args) {
		//�����ڲ��ڵ�д����
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
		//����Ķ���
		ProxyInterface proxyTarget = new ProxyTarget();
		//��ʹ�ô������Ŀ�귽��֮ǰ��֮����Ӷ��������磬��飬��־��֪ͨ����
		Adevice advice = new MyAdevice();
		//����handler���󣬷�װĿ������֪ͨ����
		MyHandler myHandler = new MyHandler(proxyTarget,advice);
		//�����������
		ProxyInterface instance = getProxy(proxyTarget, advice,myHandler);
		//ʹ�ô��������÷�����������invoke�������ݴ����Method��������Ŀ�����ķ������ڴ�֮ǰ��֮����Ե���Adevice����ķ�����
		instance.test();
		
	}

	private static ProxyInterface getProxy(ProxyInterface proxyTarget, Adevice advice,InvocationHandler handler) {
		ProxyInterface instance = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[] {ProxyInterface.class}, handler);
		return instance;
	}
}
