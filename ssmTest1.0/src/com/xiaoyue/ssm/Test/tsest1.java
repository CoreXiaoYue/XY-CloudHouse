package com.xiaoyue.ssm.Test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiaoyue.ssm.pojo.Student;
import com.xiaoyue.ssm.service.StudentService;

public class tsest1 {
    private ApplicationContext ioc;
    
    @Before
    public void init() {
	ioc =new ClassPathXmlApplicationContext("spring/applicationContext*.xml");
    }
    @Test
    public void selectAll() {
	StudentService studentService= ioc.getBean(StudentService.class);
	List<Student> list = studentService.selectAll();
	System.out.println(list);
    }
   
}
