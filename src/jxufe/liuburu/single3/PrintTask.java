/**
 * Copyright (C) 2002-2016 �����ƾ���ѧ��ͨѧԺ
 * �ļ�����jxufe.liuburu.single3PrintTask.java
 * ��  �ߣ������
 * ��  �ڣ�2016��12��5�� ����2:32:27
 * ��  ����
 * ��  ����1.0
 */
package jxufe.liuburu.single3;

import java.util.List;

public class PrintTask implements Runnable{
	
	/**
	 * ���еĵȴ���ӡ������
	 */
	private MyData myData;
	
	public PrintTask(MyData myData) {
		super();
		this.myData = myData;
	}

	@Override
	public void run() {
		try {
			myData.printDataMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
