package com.xiaoyue.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(clazz=String.class,table="BOOK",toAnnotaTation=@ToAnnotation(value="value"))
public class AnnotationTest {

	public static void main(String[] args) throws Exception {
		boolean isannotation = Entity.class.isAnnotation();
		Entity annotation = AnnotationTest.class.getAnnotation(Entity.class);
		System.out.println(annotation.clazz());//注解是一个Class类型
		System.out.println(annotation.table());//注解是一个String类型
		System.out.println(annotation.toAnnotaTation());//注解是一个注解类型
		if(isannotation) {
			Annotation[] annotations = Entity.class.getAnnotations();
			System.out.println(annotations.length);
			
		}
		Class<?> forName = Class.forName("java.lang.String");
		Object newInstance = forName.newInstance();
		Constructor<?> constructor = forName.getConstructor(String.class);
		Object newInstance2 = constructor.newInstance("小岳");
		System.out.println(newInstance2);
		
		System.out.println(add(5,6));
		Student student = new Student("小岳",25);
		List<Student> list = new ArrayList();
		System.out.println(add(list,student));
		System.out.println(list.size());
	}
	public static  int add(int a,int b) {
		return a+b;
	}
	
	public static <F> boolean add(Collection<F> desc,F args) { 
		return desc.add(args);
}
	
	
}
