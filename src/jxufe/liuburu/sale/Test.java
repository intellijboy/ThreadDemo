package jxufe.liuburu.sale;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		int N = 4;
		Pockey pockey = new Pockey();
		ExecutorService exe = Executors.newFixedThreadPool(N);
		for(int i=0;i<N;i++){
			exe.execute(new Son(pockey));
		}
		exe.shutdown();
	}
}
