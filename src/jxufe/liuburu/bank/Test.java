package jxufe.liuburu.bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		int N = 5;
		Person person = new Person();
		ExecutorService exe = Executors.newFixedThreadPool(N);
		
		for(int i=0;i<5;i++){
			exe.execute(new AddMoneyTask(person,"Ïß³Ì"+i));
		}
		exe.shutdown();
	}
}
