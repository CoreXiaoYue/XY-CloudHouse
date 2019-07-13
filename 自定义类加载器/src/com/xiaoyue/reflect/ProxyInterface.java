package com.xiaoyue.reflect;

public interface ProxyInterface {

	public void test();

}
class ProxyTarget implements ProxyInterface{

	@Override
	public void test() {
			System.out.println("动态代理对象调用");
	}
	
}