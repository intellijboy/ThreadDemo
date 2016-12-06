package jxufe.liuburu.singal;

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
			if (isLast) {
				int beginId = contios.getBeginId();
				int endId = contios.getEndId();
				contios.getMap().get(beginId).signal();
				contios.getMap().get(endId - 1).await();// �ȴ��ź���
				System.out.println(id + "������ӡ����" + data);// ��ӡ����
				i++;
				if (i == contios.getPrintCount()) {
					System.exit(888);// ϵͳ�Ƴ�
				}
				contios.getMap().get(beginId).signal();// ���·����ź���
			} else {
				int next = id + 1;
			contios.getMap().get(next).signal();
				contios.getMap().get(id).await();// �ȴ��ź���
				System.out.println(id + "������ӡ����" + data);// ��ӡ����
				contios.getMap().get(next).signal();// ���·����ź���
			}
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
