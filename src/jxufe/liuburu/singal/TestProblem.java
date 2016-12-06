/**
 * Copyright (C) 2002-2016 江西财经大学软通学院
 * 文件名：jxufe.liuburu.singalTestProblem.java
 * 作  者：刘卜铷
 * 日  期：2016年12月5日 上午10:38:50
 * 描  述：
 * 版  本：1.0
 */
package jxufe.liuburu.singal;

import org.junit.Test;
class Data{
	private int N;

	
	public Data(int n) {
		super();
		N = n;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
	
}
public class TestProblem {
	private Data data  = new Data(0);
	

	@Test
	public void test1() throws InterruptedException {
		while(true){
			Thread.sleep(1000);
			System.out.println("N1="+data.getN());
		}
	}

	@Test
	public void test2() throws InterruptedException {
		while(true){
			Thread.sleep(1000);
			data.setN(data.getN()+1);
			System.out.println("N2="+data.getN());
		}
	}
}
