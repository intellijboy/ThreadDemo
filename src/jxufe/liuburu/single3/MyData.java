package jxufe.liuburu.single3;

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
	 *数据
	 */
	private String data;
	/**
	 * 最后的数据标志量
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
	 * 打印方法
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
