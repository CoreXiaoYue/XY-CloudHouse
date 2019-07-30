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
	
	/**		���÷����ӡ�������Ԫ��
	 * @param a1  ����
	 */
	private static void reflectArrays(Object a1) {
		
		//��ȡ����ĳ���
		if(a1.getClass().isArray()) {
			int length = Array.getLength(a1);
			for(int i = 0;i<length;i++) {
				System.out.println(Array.get(a1, i));
			}
		}else {
			System.out.println(a1);
		}
		
	}

	//�������String��charAt()����
	private static void invokeMethod2(String str) throws Exception {
		//��ȡString��CharAt����
		Method invokeCharAt = str.getClass().getMethod("charAt", int.class);
		char chart = (char) invokeCharAt.invoke(str, 5);
		System.out.println(chart);
	}

	/**		������÷���
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
	 * 	 ���� ����һ�����Main����
	 * @param strings ������string����
	 * @throws Exception 
	 */
	private static void invokeObjectMain(String[] str) throws Exception {
		Class<?> clazz = Class.forName("com.xiaoyue.reflect.Test2");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, new Object[] {str});//main������һ����̬�ķ��������Բ��ö�����á�
		method.invoke(null,(Object)str);//������ǿ��ת���ɶ���
	}
	
	
	/**		���÷���ı�����ֶε�ֵ
	 * @param obj
	 * @throws Exception
	 */
	private static void changeStringValue(Object obj) throws Exception {
		//��ȡ�ֽ����ļ�����������ֶ�
		Field[] fields = obj.getClass().getDeclaredFields();
		//���������ֶ�
		for (Field field : fields) {
			field.setAccessible(true);
			//�����ȡ�ֶε�������String���ͣ��ͻ�ȡ�ֶ�ֵ��
			Boolean eqType = field.getType() == String.class;
			if(eqType == true) {
				//��ȡ���ֶ�����Ӧ�����ֵ
				String oldStr = (String) field.get(obj);
				//��ֵ�е��ַ���B���滻���ַ���a��
				String newStr = oldStr.replace('b', 'a');
				//���ı���ֵ������ǰ�Ķ����ֶ�
				field.set(obj, newStr);
			}
		}
	}

}
