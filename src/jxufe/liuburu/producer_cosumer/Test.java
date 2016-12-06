package jxufe.liuburu.producer_cosumer;

public class Test {
	public static void main(String[] args) {
		Food food = new Food();
		Thread thread1 = new Thread(new CosumerTask(food),"消费者");
		Thread thread2 = new Thread(new ProducerTask(food),"生产者");
		thread1.start();
		thread2.start();
	}
}
