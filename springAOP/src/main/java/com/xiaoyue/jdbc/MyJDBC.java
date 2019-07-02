package com.xiaoyue.jdbc;




import java.sql.SQLException;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.xiaoyue.bean.User;

//@Component("myJDBC")
public class MyJDBC {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	ApplicationContext context;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void add() {
//		this.jdbcTemplate.execute("INSERT INTO `test`.`test` (`NAME`, `kecheng`, `fenshu`) VALUES ('456456', '5456', '456456')");
	
		System.out.println(this.jdbcTemplate);
		System.out.println(context);
	}


	
	
	
	
}
