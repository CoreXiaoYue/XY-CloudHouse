package com.xiaoyue.thread;

/**
 * @author xiaoyue 实现Runnable接口实现四个窗口卖100张火车票 使用多线程。
 */
public class ImRunnableTest {

	public static void main(String[] args) {
		Window window = new Window();
		new Thread(window).start();
		new Thread(window).start();
		new Thread(window).start();
		new Thread(window).start();
	}

}

/**
 * @author Administrator 定义100张票，4个窗口同时共享这100张票。
 */
class Window implements Runnable {
	static int tacket = 100;
	
	@Override
	public void run() {
		while (true) {//循环
			synchronized (Window.class) {
				if(tacket<=0) {//循环结束条件
					System.out.println("票已售空。");
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					System.out.println(Thread.currentThread().getName() + "卖出" + tacket-- + "号票。");
			}
		}
	}

}