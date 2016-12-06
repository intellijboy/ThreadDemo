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
				System.err.println("��ʱ�ֿ���"+this.food+"����ֹͣ����....");
				this.notFull.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int random = (int) (Math.random() * 5);
		this.food += random;
		System.out.println("����������" + random + "��ǰ�ֿ�ʣ�У�" + this.food);
		notEmpty.signal();
		lock.unlock();
	}

	public void consumeFood() {
		lock.lock();
		while (food <= 0) {
			try {
				System.err.println("��ʱ�ֿ���"+this.food+"���������ߵȴ�����������....");
				this.notEmpty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int random = (int) (Math.random() * 5);
		
		while (food-random<0) {
			try {
				//System.err.println("�ֿ���"+this.food+"����������Ҫ����"+random+"������ �����ߵȴ�....");
				this.notEmpty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.food -= random;
		System.out.println("                      ����������" + random + "��ǰ�ֿ�ʣ�У�" + this.food);
		notFull.signal();
		lock.unlock();
	}

}
