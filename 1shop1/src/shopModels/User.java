package shopModels;

import java.util.ArrayList;

public class User {
	private String id;
	private int money;
	private ArrayList<Item> items;
	
	public User(String id) {
		this.id = id;
		this.money = 0;
		this.items = new ArrayList<>();
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
