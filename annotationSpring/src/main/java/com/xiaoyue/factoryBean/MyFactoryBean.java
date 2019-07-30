package com.xiaoyue.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import com.xiaoyue.bean.Pig;

public class MyFactoryBean implements FactoryBean<Pig>{

	public Pig getObject() throws Exception {
		return new Pig();
	}

	public Class<?> getObjectType() {
		return Pig.class;
	}

	public boolean isSingleton() {
		return  true;
	}



}
