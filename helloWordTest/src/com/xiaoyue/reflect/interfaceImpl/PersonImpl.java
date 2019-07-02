package com.xiaoyue.reflect.interfaceImpl;

import com.xiaoyue.reflect.interfacepackge.Person;

public class PersonImpl implements Person {

	@Override
	public void add() {
			System.out.println("添加功能");
	}

	@Override
	public void delete() {
		System.out.println("删除功能");
	}

}
