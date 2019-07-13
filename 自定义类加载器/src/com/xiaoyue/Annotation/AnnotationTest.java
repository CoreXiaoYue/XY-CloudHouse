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
		System.out.println(annotation.clazz());//ע����һ��Class����
		System.out.println(annotation.table());//ע����һ��String����
		System.out.println(annotation.toAnnotaTation());//ע����һ��ע������
		if(isannotation) {
			Annotation[] annotations = Entity.class.getAnnotations();
			System.out.println(annotations.length);
			
		}
		Class<?> forName = Class.forName("java.lang.String");
		Object newInstance = forName.newInstance();
		Constructor<?> constructor = forName.getConstructor(String.class);
		Object newInstance2 = constructor.newInstance("С��");
		System.out.println(newInstance2);
		
		System.out.println(add(5,6));
		Student student = new Student("С��",25);
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
