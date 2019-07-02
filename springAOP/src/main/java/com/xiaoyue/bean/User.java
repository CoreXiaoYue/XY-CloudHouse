package com.xiaoyue.bean;

public class User {
	private String name;
	private String kecheng;
	private double fenshu;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKecheng() {
		return kecheng;
	}
	public void setKecheng(String kecheng) {
		this.kecheng = kecheng;
	}
	public double getFenshu() {
		return fenshu;
	}
	public void setFenshu(double fenshu) {
		this.fenshu = fenshu;
	}
	public User(String name, String kecheng, double fenshu) {
		super();
		this.name = name;
		this.kecheng = kecheng;
		this.fenshu = fenshu;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", kecheng=" + kecheng + ", fenshu=" + fenshu + "]";
	}
	
}
