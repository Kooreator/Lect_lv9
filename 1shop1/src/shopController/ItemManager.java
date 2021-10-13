package shopController;

import java.util.ArrayList;

import shopModels.Category;
import shopModels.Item;

public class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Category> cartegory = CategoryManager.instance.getCategory();
	
	public ArrayList<Category> getCategory(){
		return this.cartegory;
	}
	
	public void itemPrint() {
		for(int i=0; i<this.cartegory.size(); i++) {
			for(int j=0; j<this.cartegory.get(i).getItems().size(); j++) {				
				this.cartegory.get(i).getItems().get(j).print();
			}
		}
	}
	
}
