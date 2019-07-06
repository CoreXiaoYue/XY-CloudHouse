package com.xaioyue.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiaoyue 线程的三种实现方式
 * 		1.第一种继承Thrad类创建线程
 * 		2.第二种实现Runnable接口创建线程。
 * 		3.第三种实现Callable接口和Futrue接口创建线程,call方法有返回值
 *			线程生命周期：new,Ready,Running,block
 *			线程阻塞和运行，sleep,wait,试图获取线程同步器监视器，suspend挂起。io阻塞
 *			线程的死亡：isAlive();true线程处于就绪（Ready）运行(Running)，阻塞(Block)，false:死亡(Dead)和新建状态（new）
 * 			线程的控制：join（），一个线程调用此方法时，此线程将优先执行，结束后其他线程才继续执行。
 * 			后台线程：setDaemin()将线程设置成后台线程，所有的前台线程都死亡，后台线程会自动死亡。
 *
 */
public class ThreadTest {

	@SuppressWarnings("unchecked")//抑制警告
	public  static void main(String[] args) {

		// 第一种继承Thrad类创建线程
		firstThread();
		
		// 第二种实现Runnable接口创建线程。
//		secondThread();

		// 第三种实现Callable接口创建线程,call方法有返回值
//		String callResult = thirdThread();
//		System.out.println(callResult);
		
		
		
		//使用函数式接口，lamade表达式创建线程
//		LamadaTest(callResult);
		
		

	}
	//使用jdk8的lamada表达式创建线程。
	@SuppressWarnings("unchecked")
	private static void LamadaTest(String callResult) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
			}
		}).start();
		
		new Thread(() -> {
			
		}).start();
		
		new Thread(new FutureTask(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "";
			}
		})).start();
		
		new Thread(new FutureTask<String>((Callable)()->{
			
			
			return callResult;
		})).start();
	}

	/**
	 * 第三种实现Callable接口创建线程
	 * 
	 * @return call方法有返回值
	 */
	private static String thirdThread() {
		String callResult = null;
		FutureTask ft = null;
		// 第三种实现线程方式
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "主线程：" + i);
			if (i == 20) {
				// 使用FutureTesk类包装Callable实现类的实例。
				C c = new C("xiaoyuue");
				ft = new FutureTask(c);
				// 将FutureTask的实例做为Thread的target.
				new Thread(ft).start();// 调用Start方法线程处于就绪(ready)状态，等待CPU分配时间碎片执行。

				try {
					callResult = (String) ft.get();//在主线成执行体里调用call方法返回值，将阻塞(blocked)主线程，直到new Thread(ft)线程结束返回后，在接着执行主线程。
//					System.out.println(callResult);
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
//		try {
//			callResult = (String) ft.get();//主线程耗时操作执行完后返回call方法有返回值不会阻塞主线程
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
		return callResult;
	}

	/**
	 * 使用第二种实现Runnable接口创建线程。
	 */
	private static void secondThread() {
		// 使用第二种实现Runnable接口创建线程。
		// 创建Runnable的子类实例。
		B b = new B();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "主线程：" + i);
			if (i == 20) {
				// 使用Runnable的实现类作为Thread的target.
				new Thread(b).start();// 调用Start方法线程处于就绪状态，等待CPU分配时间碎片执行。
				new Thread(b).start();
			}
		}
	}

	/**
	 *		 第一种继承Thrad类
	 *		线程阻塞和运行: sleep(),wait(),suspend(),试图获得同步监视器。
	 *		死亡测试 :isAlive()
	 *		线程的控制: join()
	 */
	private static void firstThread() {
		// 创建线程类的子类实例
		A a1 = new A();
		System.out.println("a1未调用start");
		System.out.println("线程是否死亡，"+a1.isAlive()+"处于新建和死亡状态");
		A a2 = new A();
		// 主线程执行体
		for (int a = 0; a < 100; a++) {
			
//			try {
//				Thread.sleep(100);//休眠，将执行另一个处于就绪状态的线程。
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + "主线程：" + a);
			// 当a=20,启动一个线程。
			if (a == 20) {
				// 直接使用Thread的子类调用Start().
				a1.start();// 调用Start方法线程处于就绪状态，等待CPU分配时间碎片执行。
//				a1.start();//不能对新建和死亡状态的线程调用2次Start()方法，否则会抛出IllegalThreadStateException异常。
				System.out.println("a1调用了start");
				System.out.println("线程是否死亡，"+a1.isAlive()+"处于就绪，运行，阻塞状态");
				try {
					a1.join();//线程获得优先执行权力。执行结束a1线程在执行其他线程
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		//主线程执行完毕，子线程依然在执行。主线程结束不影响子线程执行
		System.out.println("a1执行完毕");
		
	}

}

//第一种继承Thrad类
class A extends Thread {
	// 线程执行体。
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.currentThread().getName() + "线程：" + i);
			
		}
	}

}

//第二种实现Runnable接口
class B implements Runnable {
	 static  int s = 0;

	// 线程执行体
	@Override
	public void run() {
		for (; s < 100; s++) {
			System.out.println(Thread.currentThread().getName() + "线程：" + s);
		}
	}

}

//使用实现Callable接口创建线程。
class C implements Callable<String> {
	String auther;

	public C(String auther) {
		this.auther = auther;
	}

	// 线程执行体。
	// call方法可以有返回值，可以有返回值。
	@Override
	public String call() throws Exception {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "线程：" + i);
		}
		return auther;// 使用实现Callable接口创建线程方式call方法可以有返回值。
	}

}
