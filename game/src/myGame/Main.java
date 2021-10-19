package myGame;

import java.util.Random;
import java.util.Scanner;
class MainGame{
	public void run() {
		Shop.instance.setFullEquipment();
		System.out.println("======= 시작 ======\n[1.로드] [2.새 게임]\n");
		int sel = Guild.g.sc.nextInt();
		if(sel == 1) {
			FileData.instance.lode();				
		}else if(sel == 2) {
			Guild.g.setGuild();
		}
		while(true) {
			printMenu();
			int select = Guild.g.sc.nextInt();
			if(select == 1) {
				guildManage();
			}else if(select == 2) {
				shopManage();
			}else if(select == 3) {
				inventoryManage();
			}else if(select == 4) {
				FileData.instance.save();
			}else if(select == 5) {
				
			}else if(select == 0) {
				break;
			}
		}
	}
	public void battleManage() {
		
	}
	public void inventoryManage() {
		while(true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int select = Guild.g.sc.nextInt();
			if(select == 1) {
				Inventory.instance.wearingItem();
			}else if(select ==2) {
				Inventory.instance.saleItem();
			}else if(select ==0) {
				break;
			}
		}
	}
	public void shopManage() {
		while(true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int select = Guild.g.sc.nextInt();
			if(select == 1) {
				Shop.instance.printAttackEquipment(Shop.instance.getWeaponList());
				Shop.instance.buy(Shop.instance.getWeaponList());
			}else if(select == 2) {
				Shop.instance.printAttackEquipment(Shop.instance.getArmorList());
				Shop.instance.buy(Shop.instance.getArmorList());
			}else if(select == 3) {
				Shop.instance.printAttackEquipment(Shop.instance.getRingList());
				Shop.instance.buy(Shop.instance.getRingList());
			}else if(select == 0) {
				break;
			}
		}
	}
	public void guildManage() {
		while(true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("1.길드목록] [2.길드원추가] [3.길드원삭제] [4.파티원교체] [5.정렬]  [0.뒤로가기]");
			int select = Guild.g.sc.nextInt();
			if(select == 1) {
				Guild.g.printGuild();
			}else if(select == 2) {
				Guild.g.creatUnit();
			}else if(select == 3) {
				Guild.g.delete();
			}else if(select == 4) {
				Guild.g.changePartyMember();
			}else if(select == 5) {
				Guild.g.sortName();
			}else if(select == 0) {
				break;
			}
		}
	}
	public void printMenu() {
		System.out.println("===================== [메인메뉴] ======================");
		System.out.println("[1.길드관리] [2.상점] [3.인벤토리] [4.저장] [5.전투참가] [0.종료]");
		System.out.print("선택 : ");
	}
}

public class Main {
	public static void main(String[] args) {
		
		MainGame mg = new MainGame();
		mg.run();
		
	}
	
}
