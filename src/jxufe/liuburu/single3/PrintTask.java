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
	private List<MyData> myDatas;
	
	public PrintTask(List<MyData> myDatas) {
		super();
		this.myDatas = myDatas;
	}

	@Override
	public void run() {
		
	}

}
