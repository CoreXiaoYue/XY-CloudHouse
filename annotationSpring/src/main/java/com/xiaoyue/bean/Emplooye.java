package com.xiaoyue.bean;

/**
 * @author 小岳
 *
 */
public class Emplooye {
	
	public Emplooye(){
		
	}
	/**
	 * bean初始化方法
	 */
	public void init() {
		System.out.println("emplooye初始化方法");
	}
	/**
	 * bean销毁方法
	 */
	public void destroy() {
		System.out.println("emplooye的销毁方法。");
	}
}
