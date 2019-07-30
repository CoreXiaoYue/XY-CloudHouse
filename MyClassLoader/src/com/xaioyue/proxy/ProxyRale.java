package com.xaioyue.proxy;

public class ProxyRale implements Star{
	private RaleStar star;
	

	

	public ProxyRale(RaleStar star) {
		super();
		this.star = star;
	}

	@Override
	public void interview() {
		System.out.println("面谈");
	}

	@Override
	public void sign() {
		System.out.println("签合同");
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void reciveMoney() {
		System.out.println("收尾款");
	}

}
