package jxufe.liuburu.bank_plus;

public class MumTask implements Runnable {
	private BankCard bankCard;
	
	public MumTask(BankCard bankCard) {
		super();
		this.bankCard = bankCard;
	}

	@Override
	public void run() {
		while(true){
			this.bankCard.giveMoney((int)(Math.random()*5));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
