package jxufe.liuburu.sale;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pockey {
	private int money = 100;
	private Lock lock = new ReentrantLock();
	public Pockey() {
		
	}
	
	public void wasteMoney(int money){
		this.lock.lock();
		this.money-=money;
		System.out.println("Ç®´üÀï»¹Ê£:"+this.getPocket());

		this.lock.unlock();
	}
	public int getPocket() {
		return money;
	}

	public void setPocket(int pocket) {
		this.money = pocket;
	}
	
	
	
}
