package com.xiaoyue.reflect;

import java.io.InputStream;
import java.util.Properties;

public class DataSource {
	
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
	public DataSource() {
		super();
	}
	@Override
	public String toString() {
		return "DataSource [name=" + name + ", password=" + password + ", driverClass=" + driverClass + ", url=" + url
				+ "]";
	}
	

}
