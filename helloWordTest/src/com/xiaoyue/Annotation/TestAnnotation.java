package com.xiaoyue.Annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestAnnotation {
	

	@RequestMapping(Value="/test1",Method="post")
	public void Test1() {
		System.out.println("注解测试。");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建对象
		TestAnnotation testAnnotation = new TestAnnotation();
		//创建用于封装获取到注解的值对象
		AnnotationPojo annotationPojo = new AnnotationPojo();
		//获取class反射对象
		Class<? extends TestAnnotation> testClass = testAnnotation.getClass();
		//获取方法
		Method[] methods = testClass.getMethods();
		//遍历方法
		for (Method method : methods) {
			//判断方法是否使用注解
			if(method.isAnnotationPresent(RequestMapping.class)) {
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
				System.out.println("方法明："+method.getName()+",注解的属性值:value="+requestMapping.Value()+",Method="+requestMapping.Method());
				annotationPojo.setValue(requestMapping.Value());
				annotationPojo.setMethod(requestMapping.Method());
			}
		}
		
		System.out.println(annotationPojo);
		String ip=null;
		 InetAddress inetAddress;
//		for(int i =120;i>0;i--) {
//			ip="192.168.1."+i;
			ip="192.168.1.104";
			try {
				inetAddress = InetAddress.getByName(ip);
				try {
					if(inetAddress.isReachable(10000)) {
						String hostName = inetAddress.getHostName();
						String hostAddress = inetAddress.getHostAddress();
						
						System.out.println(hostName);
						System.out.println(hostAddress);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
//		}
		System.out.println("搜索完毕。");
	}

}
