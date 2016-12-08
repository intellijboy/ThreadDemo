package jxufe.liuburu.single3;

import java.util.LinkedList;

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
	 * ����
	 */
	private String data;
	/**
	 * �������ݱ�־��
	 */
	private boolean isLast;
	
	/**
	 * ��ӡ����
	 */
	private int printCount;

	/**
	 * ������
	 */
	private Object shareLock ;
	
	/**
	 * ������
	 */
	private LinkedList<Object> conds;

	public MyData(int id, String data,int printCount,boolean isLast,Object shareLock) {
		super();
		this.id = id;
		this.data = data;
		this.printCount = printCount;
		this.isLast = isLast;
		this.shareLock = shareLock;
		//��ʼ��������
		conds = new LinkedList<Object>();
		int i=0;
		while(i<printCount){
			conds.addLast(new Object());
			i++;
		}
	}

	/**
	 * ��ӡ����
	 * 
	 * @throws InterruptedException
	 */
	public void printDataMethod() throws InterruptedException {
			
				while(true){
					synchronized (shareLock) {
						//1.��ȡ��ǰ�ź���
						Object curObj = conds.peekFirst();
						//2.�ź���ת��
						conds.addLast(conds.removeFirst());
						//3.��ȡ��һ���ź���
						Object nextObj = conds.peekFirst();
						//��������һ���ź�������ô�������ź���
						if(isLast){
							nextObj.notify();
						}
						//4.���е�ǰ�ź���������l;6�ȴ�
						curObj.wait();
						//5.������һ���ź���
						nextObj.notify();
						System.out.println("data="+data);
					}
				}
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
