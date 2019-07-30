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
		//��������Դ�ļ�·��
		String classFileNmae = "className.properties";
		//��javaBean��������ֵ���ļ�·��
		String propertyFileName = "jdbc.properties";
		//������Դ�ļ�����������
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
		//������Դ�ļ���
		InputStream inputStream = Test5.class.getClassLoader().getResourceAsStream(classFileNmae);
//		System.out.println(inputStream);
		//����propertiesl���װ�ļ��洢��ֵ�Զ���
		Properties properties = new Properties();
		//����������
		properties.load(inputStream);
		inputStream.close();
		//��ȡ������Ӧ��ֵ��������ȫ·����
		String className = properties.getProperty("className");
//		System.out.println(className);
		//ͨ��ȫ·������ȡclass�ֽ������
		Class<?> clazz = Class.forName(className);
//		System.out.println(	clazz.getName());
		//����ʵ������
//		Object obj = clazz.newInstance();
		Constructor<?> constructor = clazz.getConstructor(String.class);
		Object obj = constructor.newInstance(propertyFileName);
		return obj;
	}

}
