package shopModels;

import java.util.ArrayList;

import shopMain.Shop;

public class User {
	private String id;
	private int money;
	private ArrayList<Cart> cart;
	
	public User(String id) {
		this.id = id;
		this.money = 0;
		this.cart = new ArrayList<>();
	}
	
	public String getId() {
		return this.id;
	}
	public int getMoney() {
		return this.money;
	}
	public ArrayList<Cart> getCart(){
		return this.cart;
	}
	public void setMoney(int money) {
		this.money+=money;
	}
	
	public void cartList() {
		while(true) {
			cartPrint();
			System.out.println("[1.삭제] [2.구입] [0.뒤로가기]");
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				
			}else if(select == 2) {
				
			}
		}
	}
	public void cartPrint() {
		for(int i=0; i<this.cart.size(); i++) {
			System.out.print(i+". ");
			this.cart.get(i).print();
		}
	}

}
