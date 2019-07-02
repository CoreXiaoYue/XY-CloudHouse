package com.xiaoyue.beanPostProcessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.xiaoyue.bean.Person;
import com.xiaoyue.beanFactoryPoatProcessor.Custmer;
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println(beanName +"初始化之前处理"+bean);
		if (bean instanceof Custmer) {
			System.out.println("第五步：+BeanPostProcessor，对象customBean调用初始化方法之前的数据"+bean);
		}
//		UtileLoggre.printTrack("do postProcess before initialization");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Custmer) {
			System.out.println("第八步：BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
			
		}
//		  System.out.println(bean);
//			UtileLoggre.printTrack("do post
//		 UtileLoggre.printTrack("do postProcess after initialization");
		if (bean instanceof Person) {
			Class<? extends Object> clazz = bean.getClass();
			try {
				Field nameField = clazz.getDeclaredField("name");
				nameField.setAccessible(true);
				nameField.set(bean, "小岳");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		return bean;
	}

}
