package com.xiaoyue.Annotation;

public class CustomClassLoader extends ClassLoader{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(name);
		return clazz;
	}
	
}
