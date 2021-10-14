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
		System.out.println("[1.아이템관리] [2.카테고리관리] [3.유저관리] [4.장바구니관리] [0.뒤로가기] ");
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
				userManage();
			}else if(select == 4) {
				cartManager();
			}
		}
	}
	public void cartManager() {
		while(true) {
			System.out.println("[1.결제전 항목] [0.뒤로가기]");
			int select = Shop.sc.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				this.um.fullUserCarts();
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
				this.um.userPrint();
			}else if(select ==2 ) {
				this.um.creatUser();
				this.um.userPrint();
			}else if(select == 3) {
				this.um.userPrint();
				System.out.println("삭제할 유저번호 선택 : ");
				int deleteNum = Shop.sc.nextInt();
				if(0<=deleteNum && deleteNum < this.um.getUsers().size()) {
					this.um.getUsers().remove(deleteNum);
				}
				this.um.userPrint();
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
				im.itemPrint();;
			}else if(select ==2) {
				System.out.println("category : ");
				String category = Shop.sc.next();
				if(this.cm.check(category)!=-1) {
					System.out.print("itemName : ");
					String name = Shop.sc.next();
					System.out.print("price : ");
					String price = Shop.sc.next();
					this.im.getCategory().get(this.cm.check(category)).getItems().add
					(new Item(name,Integer.parseInt(price),category));					
				}else {
					System.out.println("category 다시입력!!");
				}
			}else if(select ==3) {
				im.itemPrint();
				System.out.print("삭제할 아이템의 해당 category name 입력 : ");
				String categoryName = Shop.sc.next();
				if(this.cm.check(categoryName)!=-1) {
					for(int i=0; i<this.im.getCategory().get(this.cm.check(categoryName)).getItems().size();i++) {
						System.out.print(i+". ");
						this.im.getCategory().get(this.cm.check(categoryName)).getItems().get(i).print();
					}
					System.out.print("삭제할 아이템 번호 선택 : ");
					String num = Shop.sc.next();
					this.im.getCategory().get(this.cm.check(categoryName)).getItems().remove(Integer.parseInt(num));
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
