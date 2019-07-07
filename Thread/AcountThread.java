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


public class AcountThread extends Thread{
	private Acount acount;//操作的庄帐户
	private double drawBalance;//取款金额
	public AcountThread(Acount acount, String name, double drawBalance) {
		super(name);
		this.acount = acount;
		this.drawBalance = drawBalance;
	}
	
	public Acount getAcount() {
		return acount;
	}

	public void setAcount(Acount acount) {
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
		//使用同步代码块
				synchronized(acount) {//此时当一条线程获得次同步监视器对象锁，其他线程将无法进入此代码块。加锁-->修改-->释放锁
					if(acount.getBalance()>=drawBalance) {//余额大于取款金额
						acount.setBalance(acount.getBalance()-drawBalance);
//						try {
						
//							Thread.sleep(2000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						
						System.out.println(getName()+"成功取款："+drawBalance+"余额为："+acount.getBalance());
					}else{
						System.out.println("帐户余额不足。"+getName()+"取款失败。");
					}
				}
				//同步方法结束，该线程释放同步锁。
			}

	
	
	public static void main(String[] args) {
		Acount acount = new Acount("215245",800.0);
		//创建两条线程同时对一个帐户进行操作。
		AcountThread acountthread = new AcountThread(acount,"甲线程",500.0);
		acountthread.setPriority(MIN_PRIORITY);//设置线程优先级，优先级越高执行的机会越大
		acountthread.start();
		AcountThread acountthread1 = new AcountThread(acount,"乙线程",300.0);
		acountthread1.setPriority(MAX_PRIORITY);
		acountthread1.start();
	}
	
}

//模拟帐户取钱
class Acount{
	private String id;//账号编号
	private Double balance;//余额
	public Acount(String id, Double balance) {
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
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Acount() {
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
		Acount other = (Acount) obj;
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