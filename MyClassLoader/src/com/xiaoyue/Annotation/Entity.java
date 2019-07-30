package com.xiaoyue.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
	Class clazz()  ;//��һ��Class����
	String table()  ;
	ToAnnotation toAnnotaTation() ;//��һ��ע������
}
