package com.xiaoyue.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@MapperScan(basePackages= {"com.xiaoyue.web.mapper"})
@SpringBootApplication
@ServletComponentScan
public class App {
	public static void main(String[] args) {//启动spring应用类
		SpringApplication.run(App.class, args);
	}
}
