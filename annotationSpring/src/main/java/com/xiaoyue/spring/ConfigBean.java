package com.xiaoyue.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.xiaoyue.bean.Dog;
import com.xiaoyue.bean.Emplooye;
import com.xiaoyue.bean.Person;
import com.xiaoyue.factoryBean.MyFactoryBean;
import com.xiaoyue.importSelectBean.MyImportBeanDefinitionRegistar;
import com.xiaoyue.importSelectBean.MyInportSelect;

@Configuration
/*
 * 扫描指定包，includeFilters包含，excludeFilters=排除
 * @ComponentScan(basePackages = { "com.xiaoyue" }, includeFilters = {
 * 
 * @Filter(type = FilterType.ANNOTATION, classes = {Service.class})}
 * ,useDefaultFilters = false )
 */

/* @ComponentScan(basePackages = { "com.xiaoyue" }) */

//@Import(value = {Person.class,MyInportSelect.class})//MyImportSelect为实现ImportSelect接口,selectImports方法返回String数组，元素为bean的全类名

@ComponentScan(basePackages = { "com.xiaoyue" }, includeFilters = {

		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class,Service.class}) }, excludeFilters = {

				@Filter(type = FilterType.ANNOTATION, classes = { Repository.class }) }
		, useDefaultFilters = false)
@Import(value = {Person.class,Dog.class,MyImportBeanDefinitionRegistar.class,MyFactoryBean.class})//手动添加组件，MyImportBeanDefinitionRegistar类实现ImportBeanDefinitionRegistrar接口
public class ConfigBean {
//	@Lazy
//	@Scope(value = "singleton")
	@Bean(initMethod="init",destroyMethod ="destroy")
	public Emplooye emplooye() {
		System.out.println("emplooye创建");
		return new Emplooye();
	}

}
