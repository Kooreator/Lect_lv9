package shopController;

import java.util.ArrayList;

import shopMain.Shop;
import shopModels.Category;
import shopModels.Item;



public class CategoryManager {
	
	public static CategoryManager instance = new CategoryManager();
	private ArrayList<Category> categorys; 
	
	
	public CategoryManager() {
		this.categorys = new ArrayList<>();
		
	}
	public void init() {
		categorys.add(new Category("과자"));
		categorys.add(new Category("생선"));
		categorys.add(new Category("육류"));
		categorys.add(new Category("음료수"));
		Item temp = new Item("새우깡", 1000, categorys.get(0).getName());
		this.categorys.get(0).getItems().add(temp);
		temp = new Item("고등어", 2000, categorys.get(1).getName());
		this.categorys.get(1).getItems().add(temp);
		temp = new Item("칸쵸", 3600, categorys.get(0).getName());
		this.categorys.get(0).getItems().add(temp);
		temp = new Item("소고기", 6500, categorys.get(2).getName());
		this.categorys.get(2).getItems().add(temp);
		temp = new Item("콜라", 500, categorys.get(3).getName());
		this.categorys.get(3).getItems().add(temp);
		temp = new Item("새우", 1800, categorys.get(1).getName());
		this.categorys.get(1).getItems().add(temp);
	}
	
	public ArrayList<Category> getCategory(){
		return this.categorys;
	}
	
	public void categoryprint() {
		for(int i=0; i<this.categorys.size(); i++) {
			System.out.println(i+". "+this.categorys.get(i).getName());
		}
	}
	public void selectCategoryMenu(int select) {
		if(0<=select&&select<this.categorys.size()) {
			for(int i=0; i<this.categorys.size(); i++) {
				if(select==i) {
					System.out.println("장바구니에 담을 아이템번호를 입력하세요 : ");
					this.categorys.get(i).itemsprint();
					System.out.print("item num : ");
					int sel = Shop.sc.nextInt();
					this.categorys.get(i).selectItemsMenu(sel);
					System.out.println("담기완료!!");
				}
			}
		}
	}
	public int check(String name ) {
		int check = -1;
		for(int i=0; i<this.categorys.size(); i++) {
			if(this.categorys.get(i).getName().equals(name)) {
				check = i;
			}
		}
		return check;
		
	}
}
