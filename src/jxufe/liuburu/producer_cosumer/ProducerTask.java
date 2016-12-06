package jxufe.liuburu.producer_cosumer;

public class ProducerTask implements Runnable {
	private Food food;
	
	public ProducerTask(Food food) {
		super();
		this.food = food;
	}

	@Override
	public void run() {
		while(true){
			this.food.produceFood();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
