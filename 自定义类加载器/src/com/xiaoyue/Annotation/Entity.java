package com.xiaoyue.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
	Class clazz()  ;//是一个Class类型
	String table()  ;
	ToAnnotation toAnnotaTation() ;//是一个注解类型
}
