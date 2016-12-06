/**
 * Copyright (C) 2002-2016 江西财经大学软通学院
 * 文件名：jxufe.liuburu.single3PrintTask.java
 * 作  者：刘卜铷
 * 日  期：2016年12月5日 下午2:32:27
 * 描  述：
 * 版  本：1.0
 */
package jxufe.liuburu.single3;

import java.util.List;

public class PrintTask implements Runnable{
	
	/**
	 * 所有的等待打印的数据
	 */
	private List<MyData> myDatas;
	
	public PrintTask(List<MyData> myDatas) {
		super();
		this.myDatas = myDatas;
	}

	@Override
	public void run() {
		
	}

}
