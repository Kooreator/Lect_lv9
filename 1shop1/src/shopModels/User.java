package shopModels;

public class User {
	private String id;
	private int money;
	
	public User(String id) {
		this.id = id;
		this.money = 0;
	}
	
	public String getId() {
		return this.id;
	}
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money+=money;
	}

}
