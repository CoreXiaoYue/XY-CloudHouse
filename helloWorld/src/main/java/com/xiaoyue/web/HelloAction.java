package com.xiaoyue.web;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("进入了HelloAction");
		return SUCCESS;
	}
	
	public String add() {
		System.out.println("进入了HelloAction执行了add方法。");
		return SUCCESS;
		
	}
	
}
