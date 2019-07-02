package com.xiaoyue.configFile;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaoyue.Dao.PersonDaoImpl;
import com.xiaoyue.beanFactoryPoatProcessor.Custmer;
import com.xiaoyue.jdbc.MyJDBC;
@ComponentScan({"com.xiaoyue.beanFactoryPoatProcessor","com.xiaoyue.beanPostProcessor","com.xiaoyue.listener","com.xiaoyue.jdbc"})
@Configuration
public class ConfigrationBeanFactoryPostProcessor {
	
	
	@Bean("custmer1")
	public Custmer custmer() {
		return new Custmer();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("a1b2c3d4");
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	
	@Bean
	public MyJDBC myJDBC() throws Exception {
		return new MyJDBC();
		
	}
	
	
}
