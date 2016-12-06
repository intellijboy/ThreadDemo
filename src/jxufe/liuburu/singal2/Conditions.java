package jxufe.liuburu.singal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �źź�������
 * 
 * @author ����� 2016��12��2�� ����11:18:45
 */
public class Conditions {
	/**
	 * ������
	 */
	private Lock lock = new ReentrantLock();

	/**
	 * �ź���(һ��ѭ������)
	 */
	private LinkedList<Condition> condios;

	/**
	 * ��ӡ����
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
