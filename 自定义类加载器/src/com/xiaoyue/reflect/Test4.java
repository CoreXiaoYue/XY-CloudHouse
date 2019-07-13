package com.xiaoyue.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test4 {

	public static void main(String[] args) throws Exception {
		//类名的资源文件路劲
		String classFileNmae = "className.properties";
		//加载资源文件，创建对象
		DataSource dataSource = (DataSource) loadResourceNewInstance(classFileNmae);
		//对javaBean设置属性值的文件路劲
		String propertyFileName = "jdbc.properties";
		//将加载的文件中的内容设置到指定对象的属性中。
		setProperty(dataSource, propertyFileName);
		System.out.println(dataSource);
		}

	private static void setProperty(DataSource dataSource, String propertyFileName)
			throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException {
		//加载属性文件
		InputStream inputStream = Test4.class.getClassLoader().getResourceAsStream(propertyFileName);
//		System.out.println(inputStream);
		//创建propertiesl类封装文件存储键值对对象
		Properties properties = new Properties();
		//加载输入流
		properties.load(inputStream);
		//通过Key获取value
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driverClass = properties.getProperty("driverClass");
		
		//获取名称为name的方法名的对象
		PropertyDescriptor dp1 = new PropertyDescriptor("name", dataSource.getClass());
		//获取指定对象的set方法
		Method writeMethodName = dp1.getWriteMethod();
		//此方法调用的是指定对象，指定参数的方法
		writeMethodName.invoke(dataSource, name);
		//
		PropertyDescriptor dp2 = new PropertyDescriptor("password", dataSource.getClass());
		Method writeMethodPassword = dp2.getWriteMethod();
		writeMethodPassword.invoke(dataSource, password);
		//
		PropertyDescriptor dp3 = new PropertyDescriptor("url", dataSource.getClass());
		Method writeMethodUrl = dp3.getWriteMethod();
		writeMethodUrl.invoke(dataSource, url);
		//
		PropertyDescriptor dp4 = new PropertyDescriptor("driverClass", dataSource.getClass());
		Method writeMethodDriverClass = dp4.getWriteMethod();
		writeMethodDriverClass.invoke(dataSource, driverClass);
	}

	/**
	 * @param classFileNmae
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private static Object loadResourceNewInstance(String classFileNmae)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//加载资源文件。
		InputStream inputStream = Test4.class.getClassLoader().getResourceAsStream(classFileNmae);
//		System.out.println(inputStream);
		//创建propertiesl类封装文件存储键值对对象
		Properties properties = new Properties();
		//加载输入流
		properties.load(inputStream);
		//获取键所对应的值，就是类全路径名
		String className = properties.getProperty("className");
//		System.out.println(className);
		//通过全路径名获取class字节码对象
		Class<?> clazz = Class.forName(className);
//		System.out.println(	clazz.getName());
		//创建实例对象
		Object obj = clazz.newInstance();
		return obj;
	}

}
