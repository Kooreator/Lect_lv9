package shopModels;

import java.util.ArrayList;

import shopMain.Shop;

public class User {
	private String id;
	private int money;
	private ArrayList<Cart> cart;
	
	public User(String id,int money) {
		this.id = id;
		this.money = money;
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
				deleteCart();
			}else if(select == 2) {
				buy();
			}
		}
	}
	public void cartPrint() {
		for(int i=0; i<this.cart.size(); i++) {
			System.out.print(i+". ");
			this.cart.get(i).print();
		}
	}
	public void deleteCart() {
		System.out.print("삭제할 품목번호 선택 : ");
		String select = Shop.sc.next();
		if(0<=Integer.parseInt(select)&&Integer.parseInt(select)<this.cart.size()) {
			this.cart.remove(Integer.parseInt(select));
		}
	}
	public void buy() {
		cartPrint();
		System.out.print("구매할 품목번호 선택 : ");
		String select = Shop.sc.next();
		if(0<=Integer.parseInt(select)&&Integer.parseInt(select)<this.cart.size()) {
			if(this.money>=this.cart.get(Integer.parseInt(select)).getPrice()) {
				this.money-=this.cart.get(Integer.parseInt(select)).getPrice();
				this.cart.remove(Integer.parseInt(select));
				System.out.println("구매완료");				
			}else {
				System.out.println("Money 잔액 부족");
			}
		}
	}
	public void userPrint() {
		System.out.println(this.id+" : "+this.money);
	}
	public String  userInfo() {
		String info = this.id+"/"+String.valueOf(this.money);
		return info;
	}

}
