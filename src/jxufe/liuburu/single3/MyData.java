package jxufe.liuburu.single3;

import java.util.concurrent.locks.Condition;

/**
 * ��Ҫ��ӡ�����ݶ���
 * 
 * @author ����� 2016��12��3�� ����12:54:21
 */
public class MyData {
	/**
	 * ���ݱ�־ID
	 */
	private int id;
	/**
	 *����
	 */
	private String data;
	/**
	 * �������ݱ�־��
	 */
	private boolean isLast;


	public MyData() {
		
	}
	

	public MyData(int id, String data, boolean isLast) {
		super();
		this.id = id;
		this.data = data;
		this.isLast = isLast;
	}


	/**
	 * ��ӡ����
	 * 
	 * @throws InterruptedException
	 */
	public void printDataMethod() throws InterruptedException {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
