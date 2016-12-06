package jxufe.liuburu.singal2;

import java.util.concurrent.locks.Condition;

/**
 * 需要打印的数据对象
 * 
 * @author 刘卜铷 2016年12月3日 上午12:54:21
 */
public class MyData {
	/**
	 * 数据标志ID
	 */
	private int id;
	/**
	 * 数据
	 */
	private String data;
	/**
	 * 最后的数据标志量
	 */
	private boolean isLast;
	/**
	 * 条件
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
	 * 打印方法
	 * 
	 * @throws InterruptedException
	 */
	public void printDataMethod() throws InterruptedException {
		int i = 0;
		while (true) {
			contios.getLock().lock();
			Thread.sleep(500);
			Condition curCon = contios.getCondios().peek();//当前信号量
			contios.getCondios().addLast(contios.getCondios().removeFirst());//信号量转动
			Condition nextCon = contios.getCondios().peek();//下一个信号量
			if(isLast){//如果为最后一个信号量，那么就给第一个信号量发送启动信号
				nextCon.signal();
			}
			curCon.await();
			System.out.println(id + "——打印——" + data+" isLast="+isLast);// 打印任务
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
