package com.xaioyue.classLoader;

/**
 * �����Զ����FileSystemClassLoader
 * 
 * @author С��
 *
 */
public class Demo03 {
	public static void main(String[] args) throws Exception {
//		FileSystemClassLoader loader = new FileSystemClassLoader("");
//		FileSystemClassLoader loader2 = new FileSystemClassLoader("");
		Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("d:/myjava/com/xiaoyue/classLoader/HelloWorld");
		
		System.out.println(loadClass);
		
//		Class<?> c = loader.loadClass("com.xiaoyue.classLoader.HelloWorld");
//		Class<?> c2 = loader.loadClass("com.xiaoyue.classLoader.HelloWorld");
//		Class<?> c3 = loader2.loadClass("com.xiaoyue.classLoader.HelloWorld");
//
//		Class<?> c4 = loader2.loadClass("java.lang.String");
//		Class<?> c5 = loader2.loadClass("com.xiaoyue.classLoader.HelloWorld");

//		System.out.println(c.hashCode());
//		System.out.println(c2.hashCode());
//		System.out.println(c3.hashCode()); // ͬһ���࣬����ͬ�ļ��������أ�JVM��ΪҲ�ǲ���ͬ����
//		System.out.println(c4.hashCode());
//		System.out.println(c4.getClassLoader()); // �����������
//		System.out.println(c3.getClassLoader()); // �Զ�����������
//		System.out.println(c5.getClassLoader()); // ϵͳĬ�ϵ��������

	}
}
