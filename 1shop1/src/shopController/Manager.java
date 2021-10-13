package shopController;

import shopMain.Shop;
import shopModels.Category;
import shopModels.Item;

public class Manager {
	
	public static Manager instance = new Manager();
	private ItemManager im = ItemManager.instance;
	private UserManager um = UserManager.instance;
	private CategoryManager cm = CategoryManager.instance;
	
	public void print() {
		System.out.println("[1.아이템관리] [2.카테고리관리] [3.유저관리] [0.뒤로가기] ");
	}
	public void selectManageerMenu() {
		while(true) {
			print();
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				itemManage();
			}else if(select == 2) {
				categoryManage();
			}else if(select == 3) {
				
			}
		}
	}
	public void userManage() {
		while(true) {
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				
			}else if(select ==2 ) {
				
			}else if(select == 3) {
				
			}
		}
	}
	public void itemManage() {
		while(true) {
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select ==1) {
				im.print();
			}else if(select ==2) {
				System.out.print("itemName : ");
				String name = Shop.sc.next();
				System.out.print("price : ");
				String price = Shop.sc.next();
				System.out.println("category : ");
				String category = Shop.sc.next();
				im.getItems().add(new Item(name,Integer.parseInt(price),category));
			}else if(select ==3) {
				im.print();
				System.out.print("삭제할 아이템번호 선택 : ");
				String num = Shop.sc.next();
				if(0<=Integer.parseInt(num)&&Integer.parseInt(num)<im.getItems().size()) {
					im.getItems().remove(Integer.parseInt(num));					
				}
			}
		}
	}
	public void categoryManage() {
		while(true) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select ==1) {
				this.cm.categoryprint();
			}else if(select ==2) {
				System.out.println("Category Name : ");
				String name = Shop.sc.next();
				this.cm.getCategory().add(new Category(name));
			}else if(select ==3) {
				System.out.println("Delete Category Name : ");
				String name = Shop.sc.next();
				if(this.cm.check(name)==-1) {
					System.out.println("해당 카테고리를 찾지 못했습니다.");
				}else {
					this.cm.getCategory().remove(this.cm.check(name));
				}
			}
		}
	}

}
