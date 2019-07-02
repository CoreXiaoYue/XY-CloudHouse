package com.xiaoyue.trimmer;

/**
 * @author 小岳
 *装饰者设计模式
 */
public class TrimmerPattern {
	public static void main(String[] args) {
		Coder heimaStudent=new HeimaStudent(new Student());
		heimaStudent.code();
	}
}


interface Coder{
	public void code() ;
}
class Student implements Coder{

	@Override
	public void code() {
		System.out.println("javase");
		System.out.println("javaee");
	}
	
}
class HeimaStudent implements Coder{
	//1.获取被装饰者的引用
	private Student s;
	//1.通过构造方法传入装饰者的对象
	HeimaStudent(Student s){
		this.s=s;
	}

	//在方法中调用装饰者的方法
	@Override
	public void code() {
		s.code();
		System.out.println("ssh");
		System.out.println("ssm");
	}
	
}