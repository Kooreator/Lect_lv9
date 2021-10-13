package shopModels;

import java.util.ArrayList;

import shopController.UserManager;
import shopMain.Shop;
import shopModels.Item;

public class Category {
	
	private String name;
	private ArrayList<Item> items; 
	
	public Category(String name) {
		this.name = name;
		this.items = new ArrayList<>();
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Item> getItems(){
		return this.items;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void itemsprint() {
		for(int i=0; i<this.items.size(); i++) {
			System.out.print(i+". ");
			this.items.get(i).print();
		}
	}
	public void selectItemsMenu(int sel) {
		if(0<=sel && sel < this.items.size()) {
			UserManager.instance.getUsers().get(Shop.log).getCart().add
			(new Cart(this.items.get(sel).getPrice(),this.items.get(sel).getName()));
		}
	}
}
