package com.xiaoyue.spring.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xiaoyue.spring.bean.Student;


public class Test01 {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private SimpleDateFormat simpleDateFormat;
	
	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public String insert(Student student) throws SQLException{
		String sql="insert into student value(?,?,?,?)";
		jdbcTemplate=new JdbcTemplate(dataSource);
		String result="success";
		try {
			Date brithday = simFormat(student.getBrithday());
			jdbcTemplate.update(sql, new Object[]{student.getStuId(),student.getName(),student.getAge(),brithday});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Date simFormat(String brithday) throws ParseException{
		
		Date brithdays = simpleDateFormat.parse(brithday);
		return brithdays;
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Test01 test01 = ctx.getBean("test01",Test01.class);
		Student student=new Student();
		student.setStuId(4);
		student.setName("Ð¡½­");
		student.setAge(21);
		student.setBrithday("1995-10-10");
		try {
			String result = test01.insert(student);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
