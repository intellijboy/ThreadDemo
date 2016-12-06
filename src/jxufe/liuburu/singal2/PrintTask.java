package jxufe.liuburu.singal2;

/**
 * ��ӡ�߳�
 * 
 * @author ����� 2016��12��2�� ����11:09:24
 */
public class PrintTask implements Runnable {

	/**
	 * ��ӡ���ݶ���
	 */
	private MyData myData;

	public PrintTask(MyData myData) {
		super();
		this.myData = myData;
	}

	@Override
	public void run() {
		try {
			myData.printDataMethod();// ��ӡ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
