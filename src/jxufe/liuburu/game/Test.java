package jxufe.liuburu.game;


public class Test {
	public static void main(String[] args) {
		int N = 4;
		Game game = new Game();
		Thread thread1 = new Thread(new AddTask(game),"�ӷ�1");
		Thread thread2 = new Thread(new AddTask(game),"�ӷ�2");
		Thread thread3 = new Thread(new SubTask(game),"����1");
		Thread thread4 = new Thread(new SubTask(game),"����2");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		/*ExecutorService exe = Executors.newFixedThreadPool(4);
		for(int i=0;i<2;i++){
			exe.execute(new AddTask(game));
			exe.execute(new SubTask(game));
		}
		exe.shutdown();*/
	}
}
