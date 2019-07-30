package com.xaioyue.proxy;

public class Client {

	public static void main(String[] args) {
		RaleStar raleStar=new RaleStar();
		Star proxyRale = new ProxyRale(raleStar);
		proxyRale.interview();
		proxyRale.sing();
	}

}
