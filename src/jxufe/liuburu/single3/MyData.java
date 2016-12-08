package jxufe.liuburu.single3;

import java.util.LinkedList;

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
	 * 打印次数
	 */
	private int printCount;

	/**
	 * 共享锁
	 */
	private Object shareLock ;
	
	/**
	 * 条件锁
	 */
	private LinkedList<Object> conds;

	public MyData(int id, String data,int printCount,boolean isLast,Object shareLock) {
		super();
		this.id = id;
		this.data = data;
		this.printCount = printCount;
		this.isLast = isLast;
		this.shareLock = shareLock;
		//初始化锁对象
		conds = new LinkedList<Object>();
		int i=0;
		while(i<printCount){
			conds.addLast(new Object());
			i++;
		}
	}

	/**
	 * 打印方法
	 * 
	 * @throws InterruptedException
	 */
	public void printDataMethod() throws InterruptedException {
			
				while(true){
					synchronized (shareLock) {
						//1.获取当前信号量
						Object curObj = conds.peekFirst();
						//2.信号轮转动
						conds.addLast(conds.removeFirst());
						//3.获取下一个信号量
						Object nextObj = conds.peekFirst();
						//如果是最后一个信号量，那么就启动信号轮
						if(isLast){
							nextObj.notify();
						}
						//4.所有当前信号量都处于l;6等待
						curObj.wait();
						//5.发送下一个信号量
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
