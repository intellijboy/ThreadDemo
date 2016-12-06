package jxufe.liuburu.singal;

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
			if (isLast) {
				int beginId = contios.getBeginId();
				int endId = contios.getEndId();
				contios.getMap().get(beginId).signal();
				contios.getMap().get(endId - 1).await();// 等待信号量
				System.out.println(id + "——打印——" + data);// 打印任务
				i++;
				if (i == contios.getPrintCount()) {
					System.exit(888);// 系统推出
				}
				contios.getMap().get(beginId).signal();// 重新发出信号量
			} else {
				int next = id + 1;
			contios.getMap().get(next).signal();
				contios.getMap().get(id).await();// 等待信号量
				System.out.println(id + "——打印——" + data);// 打印任务
				contios.getMap().get(next).signal();// 重新发出信号量
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
