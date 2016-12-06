package jxufe.liuburu.producer_cosumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Food {
	final static int CAPACITY = 10;
	private int food;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public void produceFood() {
		lock.lock();
		while (food >= CAPACITY) {
			try {
				System.err.println("此时仓库余"+this.food+"所以停止生产....");
				this.notFull.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int random = (int) (Math.random() * 5);
		this.food += random;
		System.out.println("生产者生产" + random + "当前仓库剩有：" + this.food);
		notEmpty.signal();
		lock.unlock();
	}

	public void consumeFood() {
		lock.lock();
		while (food <= 0) {
			try {
				System.err.println("此时仓库余"+this.food+"所以消费者等待生产者生产....");
				this.notEmpty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int random = (int) (Math.random() * 5);
		
		while (food-random<0) {
			try {
				//System.err.println("仓库余"+this.food+"而消费者需要消费"+random+"，所以 消费者等待....");
				this.notEmpty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.food -= random;
		System.out.println("                      消费者消费" + random + "当前仓库剩有：" + this.food);
		notFull.signal();
		lock.unlock();
	}

}
