package jxufe.liuburu.bank_plus;


public class Test {
	public static void main(String[] args) {
		BankCard bankCard = new BankCard();
		Thread thread1 = new Thread(new MumTask(bankCard),"����");
		Thread thread2 = new Thread(new MeTask(bankCard),"����");
		thread1.start();
		thread2.start();
	}
}
