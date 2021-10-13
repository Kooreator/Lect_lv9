package shopModels;

import java.util.ArrayList;

public class Category {
	
	private String name;
	private ArrayList<Item> items; 
	
	public Category(String name, int price) {
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
	
}
