package jxufe.liuburu.game;

public class SubTask implements Runnable {
	private Game game;

	public SubTask(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void run() {
		while (true) {
			if (this.game.getData() <= 0) {
				System.out.println("����Ӯ��data=" + this.game.getData());
				break;
			}else if(this.game.getData() >= 100){
				System.out.println("��������!!!");
				break;
			}
			this.game.subTo((int)(Math.random()*5));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
