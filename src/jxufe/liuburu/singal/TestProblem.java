/**
 * Copyright (C) 2002-2016 �����ƾ���ѧ��ͨѧԺ
 * �ļ�����jxufe.liuburu.singalTestProblem.java
 * ��  �ߣ������
 * ��  �ڣ�2016��12��5�� ����10:38:50
 * ��  ����
 * ��  ����1.0
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
