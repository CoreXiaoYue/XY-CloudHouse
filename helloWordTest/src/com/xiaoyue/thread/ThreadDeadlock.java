package com.xiaoyue.thread;

import java.util.concurrent.Callable;

/**
 * @author xiaoyue
 *线程死锁
 */
public class ThreadDeadlock {
	static String wiermen="修电工";
	static String workers="水工";
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					synchronized(wiermen) {//线程获取锁
						System.out.println(Thread.currentThread().getName()+"停电了"+wiermen+"正在修理。");
							synchronized(workers) {//同步代码块不要嵌套使用。//获取锁
								System.out.println(Thread.currentThread().getName()+"停水了"+workers+"正在修理。");
						}
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					synchronized(workers) {//获取锁
						System.out.println(Thread.currentThread().getName()+"停水了"+workers+"正在修理。");
							synchronized(wiermen) {//获取锁
								System.out.println(Thread.currentThread().getName()+"停电了"+wiermen+"正在修理。");
						}
					}
				}
			}
		}.start();
		
	}

}


class Demo2 implements Runnable{
	@Override
	public void run() {
		
	}
	
	
}