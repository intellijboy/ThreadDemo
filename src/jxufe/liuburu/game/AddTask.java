package jxufe.liuburu.game;

public class AddTask implements Runnable {
	private Game game ;
	
	public AddTask(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void run() {
		while(true){
			if(this.game.getData()>=100){
				System.out.println("加法赢了data="+this.game.getData());
				break;
			}else if(this.game.getData() <= 0){
				System.out.println("加法输了!!!");
				break;
			}
			this.game.addTo((int)(Math.random()*5));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
