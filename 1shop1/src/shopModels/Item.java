package shopModels;

public class Item {
	
	private String name;
	private int price;
	private String category;
	
	public Item(String name , int price , String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getCategory() {
		return this.category;
	}
	public void print() {
		System.out.println(this.name+" : "+this.price+" : "+this.category);
	}

}
