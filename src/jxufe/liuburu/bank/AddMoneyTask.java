package jxufe.liuburu.bank;

public class AddMoneyTask implements Runnable {
	private Person me;
	private String name;
	public AddMoneyTask(Person me,String name) {
		super();
		this.me = me;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
			me.addMoney(1,this.name);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
