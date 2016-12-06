package jxufe.liuburu.singal;

import java.util.HashMap;
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
	 * 信号量
	 */
	private Map<Integer, Condition> map;

	/**
	 * 起始ID
	 */
	private int beginId;

	/**
	 * 最后ID
	 */
	private int endId;

	/**
	 * 打印次数
	 */
	private int printCount;

	public Conditions(int beginId, int endId, int printCount) {
		this.beginId = beginId;
		this.endId = endId;
		this.printCount = printCount;
		this.map = new HashMap<Integer, Condition>();
		for (int i = beginId; i < endId; i++) {
			this.map.put(i, lock.newCondition());
		}
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Map<Integer, Condition> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Condition> map) {
		this.map = map;
	}

	public int getBeginId() {
		return beginId;
	}

	public void setBeginId(int beginId) {
		this.beginId = beginId;
	}

	public int getEndId() {
		return endId;
	}

	public void setEndId(int endId) {
		this.endId = endId;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

}
