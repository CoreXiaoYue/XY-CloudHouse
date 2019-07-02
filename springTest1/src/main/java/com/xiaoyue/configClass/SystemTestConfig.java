package com.xiaoyue.configClass;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {RepositoryConfig.class,ServiceConfig.class})
public class SystemTestConfig {
	@Bean
    public DataSource dataSource() {
		return null ;
    }
}
