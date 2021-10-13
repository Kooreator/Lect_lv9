package shopController;

import java.util.ArrayList;

import shopModels.Item;

public class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
	public void print() {
		for(int i=0; i<this.items.size(); i++) {
			System.out.print(i+". ");
			this.items.get(i).print();
		}
	}
	
}
