package com.xiaoyue.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

	public static void main(String[] args) throws Exception {
		int[] ay1 = new int[] {1,2,3};
		int[] ay2 = new int[] {1,2,3,5};
		System.out.println(ay1.getClass() == ay2.getClass());//true
//		Ball ball = new Ball();	
//		changeStringValue(ball);
//		System.out.println(ball);
//		
//		invokeMethod(ball);
//		
//		String str = "abcdefgh";
//		invokeMethod2(str);	
//		
//		invokeObjectMain(new String[] {"asd","bsda","cawe"});
//		int[] a1 = new int[] {1,2,3};
//		String[] str1 = new String[] {"s","r","b"};
//		reflectArrays(a1);
//		reflectArrays(str1);
//		reflectArrays("sdas");
	}
	
	/**		利用反射打印出数组的元素
	 * @param a1  数组
	 */
	private static void reflectArrays(Object a1) {
		
		//获取数组的长度
		if(a1.getClass().isArray()) {
			int length = Array.getLength(a1);
			for(int i = 0;i<length;i++) {
				System.out.println(Array.get(a1, i));
			}
		}else {
			System.out.println(a1);
		}
		
	}

	//反射调用String的charAt()方法
	private static void invokeMethod2(String str) throws Exception {
		//获取String的CharAt方法
		Method invokeCharAt = str.getClass().getMethod("charAt", int.class);
		char chart = (char) invokeCharAt.invoke(str, 5);
		System.out.println(chart);
	}

	/**		反射调用方法
	 * @param ball
	 * @throws Exception
	 */
	private static void invokeMethod(Ball ball) throws Exception {
		Method method = ball.getClass().getMethod("test1", null);
		method.invoke(ball, null);
		Method method2 = ball.getClass().getMethod("test2",int.class,int.class);
		Object invoke = method2.invoke(ball,5,2);
		System.out.println(invoke);
	}

	/**
	 * 	 反射 调用一个类的Main方法
	 * @param strings 参数是string数组
	 * @throws Exception 
	 */
	private static void invokeObjectMain(String[] str) throws Exception {
		Class<?> clazz = Class.forName("com.xiaoyue.reflect.Test2");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, new Object[] {str});//main方法是一个静态的方法，所以不用对象调用。
		method.invoke(null,(Object)str);//将数组强制转换成对象
	}
	
	
	/**		利用反射改变类的字段的值
	 * @param obj
	 * @throws Exception
	 */
	private static void changeStringValue(Object obj) throws Exception {
		//获取字节码文件对象的所有字段
		Field[] fields = obj.getClass().getDeclaredFields();
		//遍历所有字段
		for (Field field : fields) {
			field.setAccessible(true);
			//如果获取字段的类型是String类型，就获取字段值。
			Boolean eqType = field.getType() == String.class;
			if(eqType == true) {
				//获取该字段所对应对象的值
				String oldStr = (String) field.get(obj);
				//将值中的字符‘B’替换成字符‘a’
				String newStr = oldStr.replace('b', 'a');
				//将改变后的值赋给当前的对象字段
				field.set(obj, newStr);
			}
		}
	}

}
