package com.xaioyue.thread;

import java.util.concurrent.locks.ReentrantLock;

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
 * 					  同步方法：public synchronized void draw(double drawBalance) 多条线程调用此方法时，只能有一条线程获得对Acount1对象的锁定。
 *			释放同步监视器的锁定：break,return,wait(),Exeception,error,
 *							不会释放：sleep(),yield(),suspend(),resume().
 *			同步锁(Lock):private final ReentrantLock lock = new ReentrantLock();//可重入锁
 * 							lock.lock();//锁定同步监视
 * 								执行操作。。。。
 * 							lock.unlock();//释放同步监视器锁定
 *
 */


public class AcountThread2 extends Thread{
	private Acount1 acount;//操作的庄帐户
	private double drawBalance;//取款金额
	public AcountThread2(Acount1 acount, String name, double drawBalance) {
		super(name);
		this.acount = acount;
		this.drawBalance = drawBalance;
	}
	
	public Acount1 getAcount() {
		return acount;
	}

	public void setAcount(Acount1 acount) {
		this.acount = acount;
	}


	public double getDrawBalance() {
		return drawBalance;
	}

	public void setDrawBalance(double drawBalance) {
		this.drawBalance = drawBalance;
	}

	@Override
	public void run() {
			acount.draw1(drawBalance);
	}

	
	
	public static void main(String[] args) {
		Acount1 acount = new Acount1("215245",800.0);
		//创建两条线程同时对一个帐户进行操作。
		AcountThread2 acountthread = new AcountThread2(acount,"甲线程",200.0);
		acountthread.setPriority(MAX_PRIORITY);//设置线程优先级，优先级越高执行的机会越大
		acountthread.start();
		AcountThread2 acountthread1 = new AcountThread2(acount,"乙线程",300.0);
		acountthread1.setPriority(MIN_PRIORITY);
		acountthread1.start();
	}
	
}

//模拟帐户取钱
class Acount1{
	private final ReentrantLock lock = new ReentrantLock();//可重入锁
	private String id;//账号编号
	private Double balance;//余额
	public Acount1(String id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	//同步方法。多条线程调用此方法时，只能有一条线程获得对Acount1对象的锁定。
	public synchronized void draw(double drawBalance) {
		if(balance>=drawBalance) {
			//取钱成功
			balance -=drawBalance;//减少金额
			System.out.println("成功取款："+drawBalance+",帐户余额："+balance);
		}else {
			System.out.println("余额不足取款失败。");
		}
		
	}
	//采用可重入所实现线程同步。
	public  void draw1(double drawBalance) {
		lock.lock();//锁定同步监视
		try {
			if(balance>=drawBalance) {
				//取钱成功
				balance -=drawBalance;//减少金额
				System.out.println("成功取款："+drawBalance+",帐户余额："+balance);
			}else {
				System.out.println("余额不足取款失败。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();//释放同步监视器锁定
		}
		
	}
	public Acount1() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acount1 other = (Acount1) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Acount [id=" + id + ", balance=" + balance + "]";
	}
}