package com.xiaoyue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyue.Dao.PersonDao;
@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDao personDao;
	
	public void add(int a, int b) {
		
		System.out.println("执行了"+(a/b));
		
	}

	public void del() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void selectById() {
		// TODO Auto-generated method stub
		
	}

}
