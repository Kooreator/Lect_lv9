package myGame;

public class Item {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;
	String kind;
	String name;
	int power;
	int price;
	
	public Item(String kind , String name, int power, int price) {
		this.kind=kind;
		this.name=name;
		this.power=power;
		this.price=price;
	}
	public String getInfo() {
		String info = "";
		info += this.kind+" : "+this.name+" : "+this.power+" : "+this.price;
		return info;
	}
	public void print() {
		System.out.println("이름 : "+this.kind+" 이름 : "+this.name+" 능력 : "+this.power+" 가격 : "+this.price);
	}
	public String Info() {
		String info = "";
		info += this.kind+"/"+this.name+"/"+this.power+"/"+this.price;
		return info;
	}

}
