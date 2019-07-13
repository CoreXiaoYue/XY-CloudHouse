package com.xiaoyue.reflect;

import java.lang.reflect.Method;

public class MyAdevice implements Adevice {
	long startTime = 0L;
	@Override
	public void before(Method method) {
		System.out.println(method.getName()+"��ʼִ�С�");
		startTime = System.currentTimeMillis();
	}

	@Override
	public void after(Method method) {
		long endTime = System.currentTimeMillis();
		
		System.out.println(method.getName()+"����ִ�н��������ѣ�"+(endTime-startTime)+"�롣");
	}

}
