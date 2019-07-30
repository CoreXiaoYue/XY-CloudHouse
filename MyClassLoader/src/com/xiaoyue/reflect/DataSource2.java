package com.xiaoyue.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSource2 {
	
	private String name;
	private String password;
	private String driverClass;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public DataSource2() {
		super();
	}
	public DataSource2( String propertyFileName) throws Exception {
		super();
		//加载属性文件设置属性
		setProperty(propertyFileName);
	}
	/**
	 * @param propertyFileName 属性资源文件
	 * @throws IOException
	 */
	private void setProperty(String propertyFileName) throws IOException {
		InputStream inputStream = DataSource2.class.getClassLoader().getResourceAsStream(propertyFileName);
//		System.out.println(inputStream);
		//创建propertiesl类封装文件存储键值对对象
		Properties properties = new Properties();
		//加载输入流
		properties.load(inputStream);
		inputStream.close();
		//通过Key获取value
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driverClass = properties.getProperty("driverClass");
		this.name=name;
		this.password = password;
		this.url = url;
		this.driverClass = driverClass;
	}
	@Override
	public String toString() {
		return "DataSource [name=" + name + ", password=" + password + ", driverClass=" + driverClass + ", url=" + url
				+ "]";
	}
	

}
