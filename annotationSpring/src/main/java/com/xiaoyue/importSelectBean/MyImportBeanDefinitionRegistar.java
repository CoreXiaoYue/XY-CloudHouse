package com.xiaoyue.importSelectBean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.xiaoyue.bean.Cat;

public class MyImportBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//容器是否有定义Dog类
		boolean containsBeanDefinition1 = registry.containsBeanDefinition("com.xiaoyue.bean.Dog");
		//容器是否有定义Person类
		boolean containsBeanDefinition2 = registry.containsBeanDefinition("com.xiaoyue.bean.Person");
		//以上条件都为true
		if(containsBeanDefinition1&&containsBeanDefinition2) {
			//将要添加到容器中的Bean封装到RootBeanDefinition 类中，
			RootBeanDefinition root = new RootBeanDefinition(Cat.class);
			//然后在容器中注册
			registry.registerBeanDefinition("cat",root);
		}
	}

}
