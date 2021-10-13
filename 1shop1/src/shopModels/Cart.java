package shopModels;

public class Cart {
	private String itemName; // 구입한 item
	private int price;
	
	public Cart(int price, String itemName) {
		this.price=price;
		this.itemName=itemName;
	}
	
	public int getPrice() {
		return this.price;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public void print() {
		System.out.println(this.itemName+" : "+this.price);
	}

}
