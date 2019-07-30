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
		//��������Դ�ļ�·��
		String classFileNmae = "className.properties";
		//������Դ�ļ�����������
		DataSource dataSource = (DataSource) loadResourceNewInstance(classFileNmae);
		//��javaBean��������ֵ���ļ�·��
		String propertyFileName = "jdbc.properties";
		//�����ص��ļ��е��������õ�ָ������������С�
		setProperty(dataSource, propertyFileName);
		System.out.println(dataSource);
		}

	private static void setProperty(DataSource dataSource, String propertyFileName)
			throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException {
		//���������ļ�
		InputStream inputStream = Test4.class.getClassLoader().getResourceAsStream(propertyFileName);
//		System.out.println(inputStream);
		//����propertiesl���װ�ļ��洢��ֵ�Զ���
		Properties properties = new Properties();
		//����������
		properties.load(inputStream);
		//ͨ��Key��ȡvalue
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driverClass = properties.getProperty("driverClass");
		
		//��ȡ����Ϊname�ķ������Ķ���
		PropertyDescriptor dp1 = new PropertyDescriptor("name", dataSource.getClass());
		//��ȡָ�������set����
		Method writeMethodName = dp1.getWriteMethod();
		//�˷������õ���ָ������ָ�������ķ���
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
		//������Դ�ļ���
		InputStream inputStream = Test4.class.getClassLoader().getResourceAsStream(classFileNmae);
//		System.out.println(inputStream);
		//����propertiesl���װ�ļ��洢��ֵ�Զ���
		Properties properties = new Properties();
		//����������
		properties.load(inputStream);
		//��ȡ������Ӧ��ֵ��������ȫ·����
		String className = properties.getProperty("className");
//		System.out.println(className);
		//ͨ��ȫ·������ȡclass�ֽ������
		Class<?> clazz = Class.forName(className);
//		System.out.println(	clazz.getName());
		//����ʵ������
		Object obj = clazz.newInstance();
		return obj;
	}

}
