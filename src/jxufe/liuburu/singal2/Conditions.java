package jxufe.liuburu.singal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号和锁对象
 * 
 * @author 刘卜铷 2016年12月2日 下午11:18:45
 */
public class Conditions {
	/**
	 * 锁对象
	 */
	private Lock lock = new ReentrantLock();

	/**
	 * 信号量(一个循环队列)
	 */
	private LinkedList<Condition> condios;

	/**
	 * 打印次数
	 */
	private int printCount;

	public Conditions(int N, int printCount) {
		this.printCount = printCount;
		this.condios = new LinkedList<Condition>();
		for (int i = 1; i<=N; i++) {
			this.condios.addLast(lock.newCondition());
		}
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}


	
	public LinkedList<Condition> getCondios() {
		return condios;
	}

	public void setCondios(LinkedList<Condition> condios) {
		this.condios = condios;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

}
