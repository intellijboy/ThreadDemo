package jxufe.liuburu.game;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
	private Lock lock = new ReentrantLock();
	private int data=50;

	
	public void addTo(int num){
		lock.lock();
		this.data+=num;
		System.out.println(Thread.currentThread().getName()+"-->"+this.getData());
		lock.unlock();
	}
	
	public void subTo(int num){
		lock.lock();
		this.data-=num;
		System.out.println(Thread.currentThread().getName()+"-->"+this.getData());
		lock.unlock();
	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	

}
