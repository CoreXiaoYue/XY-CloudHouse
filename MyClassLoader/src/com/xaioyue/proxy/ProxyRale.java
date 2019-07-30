package com.xaioyue.proxy;

public class ProxyRale implements Star{
	private RaleStar star;
	

	

	public ProxyRale(RaleStar star) {
		super();
		this.star = star;
	}

	@Override
	public void interview() {
		System.out.println("��̸");
	}

	@Override
	public void sign() {
		System.out.println("ǩ��ͬ");
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void reciveMoney() {
		System.out.println("��β��");
	}

}
