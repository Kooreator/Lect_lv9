package shopController;

import java.util.ArrayList;

import shopMain.Shop;
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
			for(int i=0; i<this.Categorys.size(); i++) {
				if(select==i) {
					System.out.println("[아이템] 번호를 입력하세요. ");
					this.Categorys.get(i).itemsprint();
					int sel = Shop.sc.nextInt();
					this.Categorys.get(i).selectItemsMenu(sel);
				}
			}
		}
	}
	public int check(String name ) {
		int check = -1;
		for(int i=0; i<this.Categorys.size(); i++) {
			if(this.Categorys.get(i).getName().equals(name)) {
				check = i;
			}
		}
		return check;
		
	}
}
