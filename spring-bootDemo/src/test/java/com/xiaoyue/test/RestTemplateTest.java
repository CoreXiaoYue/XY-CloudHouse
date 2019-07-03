package com.xiaoyue.test;


import org.springframework.web.client.RestTemplate;


public class RestTemplateTest {
	public static void main(String[] args) {
		RestTemplate restTemplate=new RestTemplate();
		Integer integer = restTemplate.getForObject("http://http://127.0.0.1:8080/deleteStudentById?id=5", Integer.class);
		System.out.println(integer);
	
	}
}
