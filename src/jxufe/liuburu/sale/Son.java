package jxufe.liuburu.sale;

public class Son implements Runnable {
	private Pockey pockey;
	
	public Son(Pockey pockey) {
		super();
		this.pockey = pockey;
	}

	@Override
	public void run() {
		while(true){
			if(this.pockey.getPocket()>0){
				this.pockey.wasteMoney(1);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
