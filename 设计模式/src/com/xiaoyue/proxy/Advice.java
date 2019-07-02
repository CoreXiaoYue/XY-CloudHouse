package com.xiaoyue.proxy;

import java.lang.reflect.Method;

public class Advice {
	public void postAdvice(Method method) {
		System.out.println("开始调用:"+method.getName());
	}
	public void afterAdvice(Method method) {
		System.out.println("结束调用:"+method.getName());
	}
}
