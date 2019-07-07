package com.xaioyue.thread;

/**
 * @author 小岳  2019/7/7
 * 
 * 			线程的休眠：sleep：线程休眠处于暂停状态，阻塞线程，不会获得执行机会，将会执行其他处于就绪状态的线程。
 * 					  yield： 线程暂停，线程不会阻塞，时间很短，将会执行优先级与此线程相同或比他高的并处于就绪状态的线程。
 * 
 * 			线程的优先级：setPriority(1至10),，有三个默认的优先级常量1，5，10，优先级高的执行机会多些。
 * 
 * 			线程的同步：多个线程在访问同一资源时候“偶然”出现的线程安全问题，（数据不准确），
 * 					  java提供了同步监视器解决线程安全问题。
 * 					  同步代码块：synchronized(obj){	}//此时当一条线程获得次同步监视器对象锁，其他线程将无法进入此代码块。
 * 						
 *	
 */
public class ThreadTest1 {
		
	
	public static void main(String[] args) {

		// 创建一个线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int a = 0; a < 10; a++) {
					System.out.println(Thread.currentThread().getName() + "线程：" + a);
//					try {
//						Thread.sleep(100);//线程休眠处于暂停状态，阻塞线程，不会获得执行机会，将会执行其他处于就绪状态的线程。
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					if(a==5) {
						Thread.yield();//线程暂停，线程不会阻塞，时间很短，将会执行优先级与此线程相同或比他高的并处于就绪状态的线程。
					}
				}
			}
		}).start();
		//创建一个线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int a = 0; a < 10; a++) {
					System.out.println(Thread.currentThread().getName() + "线程：" + a);
				}
			}

		}).start();
		/*  ============================================= */
		
	}
}






