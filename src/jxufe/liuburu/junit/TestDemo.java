/**
 * Copyright (C) 2002-2016 江西财经大学软通学院
 * 文件名：jxufe.liuburu.testTest.java
 * 作  者：刘卜铷
 * 日  期：2016年12月2日 上午9:25:05
 * 描  述：
 * 版  本：1.0
 */
package jxufe.liuburu.junit;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestDemo {
		
		private LinkedList<Integer> listData = new LinkedList<Integer>();

		@Test
		public void testList() throws InterruptedException{
			initListData();
			System.out.println(listData);
			System.out.println(listData.peek());
			System.out.println(listData.peekFirst());
			System.out.println(listData.peekLast());
//			while(true){
//				Thread.sleep(500);
//				int temp = listData.removeFirst();
//				System.out.println(temp);
//				listData.addLast(temp);
//				
//			}
		}
		
		public void initListData(){
			for(int i=0;i<10;i++){
				listData.addLast(i);
			}
		}
}
