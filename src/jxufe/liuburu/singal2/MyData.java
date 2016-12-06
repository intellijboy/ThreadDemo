package jxufe.liuburu.singal2;

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
	 * ����
	 */
	private String data;
	/**
	 * �������ݱ�־��
	 */
	private boolean isLast;
	/**
	 * ����
	 */
	private Conditions contios;


	public MyData() {
	}

	public MyData(int id, String data, Conditions contios, boolean isLast) {
		super();
		this.id = id;
		this.data = data;
		this.contios = contios;
		this.isLast = isLast;
	}

	/**
	 * ��ӡ����
	 * 
	 * @throws InterruptedException
	 */
	public void printDataMethod() throws InterruptedException {
		int i = 0;
		while (true) {
			contios.getLock().lock();
			Thread.sleep(500);
			Condition curCon = contios.getCondios().peek();//��ǰ�ź���
			contios.getCondios().addLast(contios.getCondios().removeFirst());//�ź���ת��
			Condition nextCon = contios.getCondios().peek();//��һ���ź���
			if(isLast){//���Ϊ���һ���ź�������ô�͸���һ���ź������������ź�
				nextCon.signal();
			}
			curCon.await();
			System.out.println(id + "������ӡ����" + data+" isLast="+isLast);// ��ӡ����
			nextCon.signal();
			contios.getLock().unlock();
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
