package myGame;

import java.util.ArrayList;
import myGame.Item;

public class Shop {
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
		this.ringList.add(new Item("악세사리","돌반지",3,100));
		this.ringList.add(new Item("악세사리","은반지",5,200));
		this.ringList.add(new Item("악세사리","금반지",10,500));
	}
	public void printAttackEquipment() {
		for(int i=0; i<this.weaponList.size(); i++) {
			System.out.print("["+(i+1)+"번] ");
			System.out.println(this.weaponList.get(i).getInfo());
		}
	}
	public void printDefenseEquipment() {
		for(int i=0; i<this.armorList.size(); i++) {
			System.out.print("["+(i+1)+"번] ");
			System.out.println(this.armorList.get(i).getInfo());
		}
	}
	public void printAccessorie() {
		for(int i=0;i<this.ringList.size();  i++) {
			System.out.print("["+(i+1)+"번] ");
			System.out.println(this.ringList.get(i).getInfo());
		}
	}
	public void buy(ArrayList<Item> list) {
			System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int select = Guild.g.sc.nextInt()-1;
//			if(0<=select&&select<list.size()) {
//				if()
//			}
	}

}
