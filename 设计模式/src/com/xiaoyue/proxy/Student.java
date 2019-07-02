package com.xiaoyue.proxy;

public class Student implements People{

	@Override
	public void doWorks() {
		System.out.println("学生不用工作。");
	}

	@Override
	public void study() {
		System.out.println("学生学习。");
	}

}
