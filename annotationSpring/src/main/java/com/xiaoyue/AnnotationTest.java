package com.xiaoyue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xiaoyue.bean.Emplooye;
import com.xiaoyue.bean.Pig;
import com.xiaoyue.spring.ConfigBean;

public class AnnotationTest {

	@SuppressWarnings("unused")
	@Test
	public void test1() {
		//加载配置类
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConfigBean.class);
		System.out.println("容器创建完成。");
		String[] names = ioc.getBeanDefinitionNames();//遍历容器中定义的所有bean的名字（id）
		for (String name : names) {
			System.out.println(name);
		}
		Emplooye bean = (Emplooye) ioc.getBean("emplooye");//获取emplooye
		Pig bean2 = ioc.getBean(Pig.class);
		System.out.println(bean2);
		Object bean3 = ioc.getBean("&emplooye");//获取Pig
		System.out.println(bean3);
		ioc.close();
		
	}

}
