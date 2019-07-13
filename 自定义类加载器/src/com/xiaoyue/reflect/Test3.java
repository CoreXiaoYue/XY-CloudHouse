package com.xiaoyue.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
public class Test3 {
	
	public static void main(String[] args) throws Exception {
//		String fileName = "className.properties";
//		Collection collection = reflectResource(fileName);
//		Collection<Student> hashSet = new HashSet();
//		Student stu1 = new Student("小岳","25");
//		Student stu2 = new Student("小山","21");
//		Student stu3 = new Student("小龙","28");
//		Student stu4 = new Student("小岳","25");
//		System.out.println(stu1.equals(stu4));
//		System.out.println(stu1 == stu4);
//		hashSet.add(stu1);
//		System.out.println(hashSet.size());
//		System.out.println("====================");
		
		Student stu5 = new Student();
		System.out.println(stu5);
		String propertyName = "name";
		String value = "大强";
		setProperty(stu5, propertyName, value);
		Object retVal1 = getProperty(stu5, propertyName);
		Object retVal2 = getProperty1(stu5, propertyName);
		System.out.println(retVal1);
		System.out.println("value:"+retVal2);
		
		String propertyName1 = "age";
		String value1 = "26";
		setProperty(stu5, propertyName1, value1);
		Object retVal3 = getProperty(stu5, propertyName1);
		Object retVal4 = getProperty1(stu5, propertyName);
		System.out.println(retVal3);
		System.out.println(retVal4);
		System.out.println(stu5);
	}

	private static void setProperty(Object stu5, String propertyName, String value)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor dp1 = new PropertyDescriptor(propertyName, stu5.getClass());
		Method writeMethod = dp1.getWriteMethod();
		writeMethod.invoke(stu5, value);
	}

	private static Object getProperty(Object stu5, String propertyName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd1 = new PropertyDescriptor(propertyName, stu5.getClass());
		//获取get方法
		Method ReadProperty = pd1.getReadMethod();
		Object retVal = ReadProperty.invoke(stu5, null);
		return retVal;
	}
	private static Object getProperty1(Object stu5, String propertyName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		//获取代表类的一个对象，封装了类的所有属性和方法
		BeanInfo beanInfo = Introspector.getBeanInfo(stu5.getClass());
		//获取的是一个类的集合
		PropertyDescriptor[] dps = beanInfo.getPropertyDescriptors();
		Object retValue = null;
		//遍历一个类集合
		for (PropertyDescriptor dp : dps) {
			boolean check = dp.getName().equals(propertyName);
			if(check) {
				Method getMethod = dp.getReadMethod();
				retValue = getMethod.invoke(stu5);
				break;
			}
		}
		return retValue;
	}
	
	/**		利用反射读取文件中的类的名称并调用方法。
	 * @param fileName
	 * @throws Exception 
	 */
	private static Collection reflectResource(String fileName) throws Exception {
			//创建输入流InputStream
//			InputStream input = new FileInputStream(fileName); 
			
			InputStream input = Test3.class.getClassLoader().getResourceAsStream(fileName);
//			InputStream input = Test3.class.getResourceAsStream(fileName);
			//常见properties对象存取文件中的键值对
			Properties properties = new Properties();
			properties.load(input);
			String className = properties.getProperty("className");
			Class<?> clazz = Class.forName(className);
			Collection collection = (Collection) clazz.newInstance();
//			System.out.println(collection);
			 return collection;
			
	}
}
