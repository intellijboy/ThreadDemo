package jxufe.liuburu.producer_cosumer;

public class CosumerTask implements Runnable {
	private Food food;
	
	public CosumerTask(Food food) {
		super();
		this.food = food;
	}

	@Override
	public void run() {
		while(true){
			this.food.consumeFood();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
