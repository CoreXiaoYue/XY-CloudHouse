package com.xaioyue.DymictProxy;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		Star raleStar = new RaleStar();
		ProxyRale proxyRale = new ProxyRale(raleStar);
		
		Star proxyStar = (Star) Proxy.newProxyInstance(Star.class.getClassLoader(), new Class[] {Star.class}, proxyRale);
		proxyStar.sing();
	}

}
