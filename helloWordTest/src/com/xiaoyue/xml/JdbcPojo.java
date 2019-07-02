package com.xiaoyue.xml;

import java.io.Serializable;

public class JdbcPojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String driverClass;
	private String url;
	private String name;
	private String password;
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
	@Override
	public String toString() {
		return "JdbcPojo [driverClass=" + driverClass + ", url=" + url + ", name=" + name + ", password=" + password
				+ "]";
	}
	public JdbcPojo(String driverClass, String url, String name, String password) {
		super();
		this.driverClass = driverClass;
		this.url = url;
		this.name = name;
		this.password = password;
	}
	public JdbcPojo() {
		super();
	}
	
	

}
