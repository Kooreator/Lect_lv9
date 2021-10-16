package myGame;

import java.util.ArrayList;

public class Inventory {
	public static Inventory instance = new Inventory();
	private ArrayList<Item> items = new ArrayList<>();
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
	public void wearingItem() {
		Guild.g.printGuild();
		System.out.print("아이템 착용할 길드원을 선택하세요 : ");
		int unitSelect = Guild.sc.nextInt()-1;
		Guild.g.getGuild().get(unitSelect).printUnitStatus();
		Guild.g.getGuild().get(unitSelect).printEquitedItem();
		while(true) {
			printItems();
			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int itemSelect = Guild.sc.nextInt()-1;
			if(-1<=itemSelect&&itemSelect<this.items.size()) {
				if(itemSelect==-1) {
					break;
				}else if(this.items.get(itemSelect).kind.equals("무기")) {
					if(Guild.g.getGuild().get(unitSelect).getWeapon()==null) {
						Guild.g.getGuild().get(unitSelect).setWeapon(this.items.get(itemSelect));
						this.items.remove(itemSelect);						
					}else {
						this.items.add(Guild.g.getGuild().get(unitSelect).getWeapon());
						Guild.g.getGuild().get(unitSelect).setWeapon(this.items.get(itemSelect));
						this.items.remove(itemSelect);
					}
				}else if(this.items.get(itemSelect).kind.equals("방어구")) {
					if(Guild.g.getGuild().get(unitSelect).getArmor()==null) {
					Guild.g.getGuild().get(unitSelect).setArmor(this.items.get(itemSelect));
					this.items.remove(itemSelect);
					}else {
						this.items.add(Guild.g.getGuild().get(unitSelect).getArmor());
						Guild.g.getGuild().get(unitSelect).setArmor(this.items.get(itemSelect));
						this.items.remove(itemSelect);
					}
				}else if(this.items.get(itemSelect).kind.equals("반지")) {
					if(Guild.g.getGuild().get(unitSelect).getRing()==null) {
					Guild.g.getGuild().get(unitSelect).setRing(this.items.get(itemSelect));
					this.items.remove(itemSelect);
					}else {
						this.items.add(Guild.g.getGuild().get(unitSelect).getRing());
						Guild.g.getGuild().get(unitSelect).setRing(this.items.get(itemSelect));
						this.items.remove(itemSelect);
					}
				}
				Guild.g.getGuild().get(unitSelect).printUnitStatus();
				Guild.g.getGuild().get(unitSelect).printEquitedItem();
			}
			
		}
	}
	public void saleItem() {
		while(true) {
			printItems();
			System.out.println("[골드 : "+Player.instance.money+"]");
			System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
			int saleSelect = Guild.sc.nextInt()-1;
			if(-1<=saleSelect&&saleSelect<this.items.size()) {
				if(saleSelect == -1) {
					break;
				}else {
					Player.instance.money+=(this.items.get(saleSelect).price/2);
					this.items.remove(saleSelect);
				}
				
			}
		}
		
		
	}
	public void printItems() {
		System.out.println("\n=============== Inventorylist ===============");
		for(int i=0; i<this.items.size(); i++) {
			System.out.print("["+(i+1)+"번] ");
			this.items.get(i).print();
		}
	}
}
