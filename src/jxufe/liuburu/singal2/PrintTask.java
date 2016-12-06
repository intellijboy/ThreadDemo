package jxufe.liuburu.singal2;

/**
 * 打印线程
 * 
 * @author 刘卜铷 2016年12月2日 下午11:09:24
 */
public class PrintTask implements Runnable {

	/**
	 * 打印数据对象
	 */
	private MyData myData;

	public PrintTask(MyData myData) {
		super();
		this.myData = myData;
	}

	@Override
	public void run() {
		try {
			myData.printDataMethod();// 打印任务
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
