package com.xiaoyue.Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) throws Exception {
		CustomClassLoader custom = new CustomClassLoader();
		Class<?> findClass = custom.findClass("com.xiaoyue.Annotation.Entity");
		System.out.println(findClass.getClassLoader().getClass().getName());
		
		MyClassLoader myClassLoader = new MyClassLoader("classloaderfoder");
		Class<?> findClass2 = myClassLoader.findClass("Student");
		Constructor<?> constructor = findClass2.getConstructor(String.class,int.class);
		Object newInstance = constructor.newInstance("ะกิภ",25);
		Method getName = findClass2.getMethod("getName", null);
		String name = (String) getName.invoke(newInstance, null);
		System.out.println(name);
		
	System.out.println(	findClass2.getClassLoader().getClass().getName());
			Demo1 demo = new Demo1();
	
	
	
			Class<?> class1 = Test1.class;
			Object newInstance2 = class1.newInstance();
//			Method del = class1.getMethod("del");
//			System.out.println(del.getName());
			Method add = class1.getMethod("add", Collection.class,Map.class);
			Type[] types = add.getGenericParameterTypes();
				for(Type type : types) {
					ParameterizedType type1 = (ParameterizedType)type;
					System.out.println(type1.getRawType());
					Type[] actualTypeArguments = type1.getActualTypeArguments();
					for(Type actType : actualTypeArguments) {
						System.out.println(actType);
					}
				}
			
			
			
//			ParameterizedType type = (ParameterizedType)types[0];
//			System.out.println(type.getRawType());
//			Type[] actualTypeArguments = type.getActualTypeArguments();
//			for(Type actType : actualTypeArguments) {
//				System.out.println(actType);
//			}
	
	
	}

	
	public Boolean add(Collection<String> list,Map<String,Integer> args) {
		
		return null;
	}
	public Boolean del() {
			
			return null;
		}
}
