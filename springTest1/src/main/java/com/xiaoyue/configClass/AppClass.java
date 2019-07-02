package com.xiaoyue.configClass;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ImportResource("classpath:/com/acme/properties-config.xml")
public class AppClass {
	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource(url, username, password);
	}
}
