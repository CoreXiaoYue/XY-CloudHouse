package com.xiaoyue.proxyJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.xiaoyue.service.PersonService;

public class MyHandler implements InvocationHandler {

	private  PersonService personService;
	private GetAdvicer getAdvicer;
	

	public MyHandler() {
		super();
	}



	public MyHandler(PersonService personService, GetAdvicer getAdvicer) {
		super();
		this.personService = personService;
		this.getAdvicer = getAdvicer;
	}





	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Class<? extends PersonService> class1 = personService.getClass();
		String name2 = class1.getName()+"."+method.getName();
		System.out.println(name2);
		//获取方法名
		String[] methodName = getAdvicer.getMethodName();
		for (String name : methodName) {
			if(name.contains(name2)) {
				System.out.println("调用："+method.getName()+"方法");
				if(args!=null) {
					System.out.println("参数是："+"{"+Arrays.asList(args)+"}");
				}
//		Object invoke = method.invoke(personService, args);
//		System.out.println("结果："+invoke);
				System.out.println("调用："+method.getName()+"方法结束");
				return null;
			}else {
				System.out.println("没有通知");
			}
		}
		
		return null;
	}

}
