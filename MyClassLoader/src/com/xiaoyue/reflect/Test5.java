package com.xiaoyue.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test5 {

	public static void main(String[] args) throws Exception {
		//类名的资源文件路劲
		String classFileNmae = "className.properties";
		//对javaBean设置属性值的文件路劲
		String propertyFileName = "jdbc.properties";
		//加载资源文件，创建对象
		DataSource2 dataSource2 = (DataSource2) loadResourceNewInstance(classFileNmae,propertyFileName);
		System.out.println(dataSource2);
		}

	private static void setProperty(DataSource dataSource, String propertyFileName) {

	}

	/**
	 * @param classFileNmae
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private static Object loadResourceNewInstance(String classFileNmae, String propertyFileName)
			throws Exception {
		//加载资源文件。
		InputStream inputStream = Test5.class.getClassLoader().getResourceAsStream(classFileNmae);
//		System.out.println(inputStream);
		//创建propertiesl类封装文件存储键值对对象
		Properties properties = new Properties();
		//加载输入流
		properties.load(inputStream);
		inputStream.close();
		//获取键所对应的值，就是类全路径名
		String className = properties.getProperty("className");
//		System.out.println(className);
		//通过全路径名获取class字节码对象
		Class<?> clazz = Class.forName(className);
//		System.out.println(	clazz.getName());
		//创建实例对象
//		Object obj = clazz.newInstance();
		Constructor<?> constructor = clazz.getConstructor(String.class);
		Object obj = constructor.newInstance(propertyFileName);
		return obj;
	}

}
