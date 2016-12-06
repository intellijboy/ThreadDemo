package jxufe.liuburu.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Person {
	private int pocket = 0;	//公共资源
	private Lock lock = new ReentrantLock();
	public Person() {
		
	}
	
	public void addMoney(int money,String name){
		this.lock.lock();
		this.pocket+=money;
		System.out.println(name+"--->"+this.getPocket());
		if(getPocket()==50){
			System.out.println("程序退出");
			System.exit(0);
		}
		this.lock.unlock();
	}

	public int getPocket() {
		return pocket;
	}

	public void setPocket(int pocket) {
		this.pocket = pocket;
	}
	
	
	
}
