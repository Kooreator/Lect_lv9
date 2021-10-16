package myGame;

import java.util.ArrayList;
import myGame.Item;

public class Shop {
	public static Shop instance = new Shop();
	private ArrayList<Item> weaponList = new ArrayList<>();
	private ArrayList<Item> armorList = new ArrayList<>();
	private ArrayList<Item> ringList = new ArrayList<>();
	
	public ArrayList<Item> getWeaponList(){
		return this.weaponList;
	}
	public ArrayList<Item> getArmorList(){
		return this.armorList;
	}
	public ArrayList<Item> getRingList(){
		return this.ringList;
	}
	public void setFullEquipment() {
		setAttackEquipment();
		setDefenseEquipment();
		setAccessorie();
	}
	public void setAttackEquipment() {
		this.weaponList.add(new Item("무기","돌칼",3,100));
		this.weaponList.add(new Item("무기","강철검",6,200));
		this.weaponList.add(new Item("무기","전설의 소드",10,500));
	}
	public void setDefenseEquipment() {
		this.armorList.add(new Item("방어구","철갑옷",3,100));
		this.armorList.add(new Item("방어구","방탄복",6,200));
		this.armorList.add(new Item("방어구","첨단소재수트",10,500));
	}
	public void setAccessorie() {
		this.ringList.add(new Item("반지","돌반지",3,100));
		this.ringList.add(new Item("반지","은반지",5,200));
		this.ringList.add(new Item("반지","금반지",10,500));
	}
	public void printAttackEquipment(ArrayList<Item> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print("["+(i+1)+"번] ");
			System.out.println(list.get(i).getInfo());
		}
	}
	public void buy(ArrayList<Item> list) {
			System.out.println("\n구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
			System.out.println("PlayerMoney : "+Player.instance.money+"\n번호 : ");
			int select = Guild.g.sc.nextInt()-1;
			if(0<=select&&select<list.size()) {
				if(Player.instance.money>=list.get(select).price) {
					Player.instance.money-=list.get(select).price;
					Player.instance.inventory.getItems().add(list.get(select));
				}
			}
	}

}
