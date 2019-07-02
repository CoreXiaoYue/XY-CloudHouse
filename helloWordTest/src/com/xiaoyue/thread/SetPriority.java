package com.xiaoyue.thread;

public class SetPriority extends Thread{

	@Override
	public void run() {
		Demo demo = new Demo();
		while (true) {
			demo.printlnTest1();
		}
	}

	public static void main(String[] args) {
//		SetPriority setPriority = new SetPriority();
//		setPriority.start();
		final Demo demo = new Demo();
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					demo.printlnTest1();
				}
			}
		};
		thread.start();
		
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				while(true) {
					demo.printlnTest2();
				}
			}
		};
		thread1.start();
	}

}

class Demo {
	Object object=new Object();
	public synchronized void printlnTest1() {
		 
			System.out.print("+");
			System.out.print("+");
			System.out.print("+");
			System.out.print("+");
			System.out.print("+");
			System.out.println("\r\n");
			
		
	}

	public synchronized void printlnTest2() {
		System.out.print("-");
		System.out.print("-");
		System.out.print("-");
		System.out.print("-");
		System.out.print("-");
		System.out.println("\r\n");
	}
}
