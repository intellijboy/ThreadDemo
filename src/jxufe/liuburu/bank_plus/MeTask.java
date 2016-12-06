package jxufe.liuburu.bank_plus;

public class MeTask implements Runnable {
	private BankCard bankCard;
	
	public MeTask(BankCard bankCard) {
		super();
		this.bankCard = bankCard;
	}

	@Override
	public void run() {
		while(true){
			this.bankCard.wasteMoney((int)(Math.random()*10));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
