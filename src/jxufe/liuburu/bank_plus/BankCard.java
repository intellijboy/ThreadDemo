package jxufe.liuburu.bank_plus;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankCard {
	private int  money;
	private Lock lock = new ReentrantLock();
	private Condition sinal = lock.newCondition();
	
	public void wasteMoney(int money){
		lock.lock();
		while(getMoney()<=money){
			try {
				sinal.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.money-=money;
		System.out.println("                  Son������"+money+"��ǰ���Ϊ��"+this.money);
		lock.unlock();
	}
	
	public void giveMoney(int money){
		
			lock.lock();
			this.money+=money;
			System.out.println("Mum������"+money+"��ǰ���Ϊ��"+this.money);
			this.sinal.signal();
			lock.unlock();
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
