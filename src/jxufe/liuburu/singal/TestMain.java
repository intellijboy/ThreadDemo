package jxufe.liuburu.singal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
	public static void main(String[] args) {
		// 100��105�ֱ��ʾ��Сid��������ݱ�־ID
		Conditions contios = new Conditions(100, 105, 3);// ��ӡ12��
		// ע��id ����Ϊ������Nλ����
		MyData data1 = new MyData(100, "A", contios, false);
		MyData data2 = new MyData(101, "B", contios, false);
		MyData data3 = new MyData(102, "C", contios, false);
		MyData data4 = new MyData(103, "D", contios, false);
		MyData data5 = new MyData(104, "E", contios, true);// ע:���һ���ڵ��־Ϊtrue
		PrintTask task1 = new PrintTask(data1);
		PrintTask task2 = new PrintTask(data2);
		PrintTask task3 = new PrintTask(data3);
		PrintTask task4 = new PrintTask(data4);
		PrintTask task5 = new PrintTask(data5);
		// �̳߳�
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(100);
		cachedThreadPool.execute(task1);
		cachedThreadPool.execute(task2);
		cachedThreadPool.execute(task3);
		cachedThreadPool.execute(task4);
		cachedThreadPool.execute(task5);
	}
}
