package com.xiaoyue.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class Test6 {

	public static void main(String[] args) {
		Class<?> proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
//		Class<?> proxyClass = Collection.class;
		System.out.println(proxyClass.getName());
//		Class clazz = Collection.class;
		Constructor[] constructors = proxyClass.getConstructors();
		for(Constructor constructor : constructors) {
			String name = constructor.getName();
			StringBuilder sb = new StringBuilder(name);
			Class[] params = constructor.getParameterTypes();
			sb.append("(");
			for(Class param : params) {
				sb.append(param.getName()).append(",");
			}
			if(params != null && params.length != 0) {
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(")");
			System.out.println(sb);
		}
		
		Method[] methods = proxyClass.getMethods();
		for(Method method : methods) {
			//获取方法名
			String methodName = method.getName();
			
			//创建拼接可变字符串
			StringBuilder sbm = new StringBuilder(methodName); 
			//获取方法的参数类型
			Class<?>[] methodParameter = method.getParameterTypes();
			//对方法参数进行遍历
			sbm.append("(");
			for(Class meParamter : methodParameter) {
				sbm.append(meParamter.getName()).append(",");
			}
			if(methodParameter !=null && methodParameter.length != 0) {
				sbm.deleteCharAt(sbm.length()-1);
			}
			sbm.append(")");
			System.out.println(sbm);
		}
		
		
		
	}

}
