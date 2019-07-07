package com.xaioyue.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小岳
 * 		死锁：多条线程互相等待对方释放同步监视器锁时就会发生死锁。
 * 			A线程获得了a对象同步监视器进行锁定，此时出现阻塞状态，B线程获得b对象同步监视器进行锁定。A线程恢复想要获得b对象同步监视器锁，
 * 				结果B线程已经在A线程处于阻塞状态时将b对象锁定了。所以A线程此时就将处于等待状态，等待B线程释放b，同理，B线程也是执行相同操作。
 * 					A线程要获得B线程已经锁定的资源，B对象要获得A线程已经锁定的资源。A，B两线程都处于等待状态。于是就造成了死锁。				
 * 		解决死锁：避免一条线程对多个同步监视器进行锁定。
 * 				应保证多条线程以相同的顺序请求加锁。
 * 				使用定是锁，Lock.tryLock(  ,  ),超时将自动解开死锁。
 * 				死锁检测，依靠算法实现，针对以上方式不能实现按序加锁和定时加锁的场景。
 * 
 * 
 *
 */
public class DeadLock implements Runnable{
//	 ReentrantLock lock = new ReentrantLock();//可重入锁
	A1 a1 = new A1();
	B1 b1 = new B1();
	
	
	public void init() {
		b1.bar(a1);//锁定b1对象
	}
	

	public static void main(String[] args) {
		
		DeadLock deadLock = new DeadLock();
		
		new Thread(deadLock).start();
		deadLock.init();
	}



	@Override
	public void run() {
		a1.foo(b1);//锁定a1对象
	}

}
class C1{
	 final ReentrantLock lock = new ReentrantLock();//可重入锁
}


class A1 extends C1{
	
	public synchronized void foo(B1 b) {//锁定a对象
//		lock.lock();
		System.out.println(Thread.currentThread().getName()+"线程进入A执行foo方法");
		try {
			Thread.sleep(500);//休眠500毫秒。进入阻塞状态，此时已锁定对象a,其他处于就绪状态的线程获得执行机会，此时a对象锁没有被释放。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//线程休眠结束，将对b进行锁定，假设在上面休眠中另一个线程随b对象进行了加锁操作。此时将无法获得b对象锁，就处于阻塞等待状态。
		
		b.last();//对b对象进行加锁
//		lock.unlock();
	}
	public synchronized void last() {
		System.out.println(Thread.currentThread().getName()+"执行了B的last方法");
	}
}

class B1 extends C1{
	
	public synchronized void bar(A1 a) {//锁定b对象
//		lock.lock();
		System.out.println(Thread.currentThread().getName()+"线程进入B执行bar方法");
		try {
			Thread.sleep(500);//休眠500毫秒。进入阻塞状态，此时已锁定对象所b,其他处于就绪状态的线程获得执行机会，此时b对象锁没有被释放
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		//线程休眠结束，将对a进行锁定，假设在上面休眠中另一个线程对a对象进行了加锁操作。此时将无法获得a对象锁，就处于阻塞等待状态。
		a.last();//对a对象进行加锁
//		lock.unlock();
//		lock.tryLock();
	}
	
	public synchronized void last() {
		System.out.println(Thread.currentThread().getName()+"执行了B的last方法");
	}
}