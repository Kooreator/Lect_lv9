package shopController;

import java.util.ArrayList;

import shopModels.Category;



public class CategoryManager {
	
	public static CategoryManager instance = new CategoryManager();
	private ArrayList<Category> Categorys; 
	
	public CategoryManager() {
		this.Categorys = new ArrayList<>();
	}
	
	public ArrayList<Category> getCategory(){
		return this.Categorys;
	}
	
	public void categoryprint() {
		for(int i=0; i<this.Categorys.size(); i++) {
			System.out.println(i+". "+this.Categorys.get(i).getName());
		}
	}
	public void selectCategoryMenu(int select) {
		if(0<=select&&select<this.Categorys.size()) {
			
		}
	}

}
