package com.xaioyue.thread;


/**
 * @author 小岳
 * 			线程的通信：wait(),notofy(),notifyAll(),
 * 
 * 				Lock lock = new ReetrantLock();可重入是锁，同步锁
 * 				通过Lock对象的newCondition()获取Condition对象。
 * 				加锁后调用Condition的await()方法让线程等待;
 * 						signal，	signalAll();唤醒其他线程
 *
 */
public class AcountThread3 {

	public static void main(String[] args) {
		Acount2 acount2 = new Acount2("124545", 0.0);
		new Person2(acount2, 800.0).start();
		new Person1(acount2, 800.0).start();
		//执行完之后，线程将进入阻塞状态
		//线程死锁与阻塞区别：死锁是等待其他线程释放同步监视器锁，而阻塞是等待其他线程执行而已。
	}

}


//模拟帐户取钱
class Acount2 {
//	private final ReentrantLock lock = new ReentrantLock();//可重入锁
	private String id;// 账号编号
	private Double balance;// 余额
	private boolean flog = false;// 标记帐户是否有存款.

	public Acount2(String id, Double balance) {
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

	// 取钱操作
	// 同步方法。多条线程调用此方法时，只能有一条线程获得对Acount1对象的锁定。
	public synchronized void draw(double drawBalance) {
		try {
			if (!flog) {// 没有存钱,等待存钱
				wait();
			} else {
				balance -= drawBalance;
				System.out.println(Thread.currentThread().getName() + "成功取款：" + drawBalance + ",帐户余额：" + balance);
				flog = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// 存钱操作
	public synchronized void deposit(double depositBalance) {
		try {
			if (flog) {// 钱未取走,无法存钱
				wait();
			} else {
				balance += depositBalance;
				System.out.println(Thread.currentThread().getName() + "存款：" + depositBalance + "余额：" + balance);
				flog = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Acount2() {
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
		Acount2 other = (Acount2) obj;
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


//取钱人
class Person1 extends Thread {
	public Acount2 acount;
	private double drawBalance;

	public Person1(Acount2 acount, double drawBalance) {
		this.acount = acount;
		this.drawBalance = drawBalance;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {//模拟从账户取20次钱
		acount.draw(drawBalance);
		}
	}

}

//存钱人
class Person2 extends Thread {
	public Acount2 acount;
	private double depositBalance;

	public Person2(Acount2 acount, double depositBalance) {
		this.acount = acount;
		this.depositBalance = depositBalance;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {//循环存20次钱进帐户。
		acount.deposit(depositBalance);
		}
	}

}
