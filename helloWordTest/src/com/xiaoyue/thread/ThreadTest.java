package com.xiaoyue.thread;

public class ThreadTest extends Thread{
	
	
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(1000);
				System.out.println("当前线程："+this.getName()+","+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadTest threadTest = new ThreadTest();
		String string="sads";
		
//		Thread thread = new Thread(threadTest);
//		thread.start();
		threadTest.start();
		System.out.println(threadTest.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(threadTest.getId());//10
		System.out.println(Thread.activeCount());//2
		System.out.println(Thread.currentThread().getId());//1
		System.out.println(threadTest.isAlive());
		for (int i = 0; i < 10; i++) {
			sleep(1000);
			System.out.println("当前线程："+Thread.currentThread().getName()+","+i);
			if(i==5) {
				System.out.println("即将加入线程"+threadTest.getName()+"线程。"+Thread.currentThread().getName()+"处于等待状态。");
				
				threadTest.join();//加入线程，
				
			}
		}
		
		new Thread() {
			@Override
			public void run() {
				super.run();
			}
		}.start();
		
		new Runnable() {
			
			@Override
			public void run() {
				
			}
		};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}) .start();
			
	
	}
}
