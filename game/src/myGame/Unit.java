package myGame;

public class Unit {
	private String name;  private int level; private boolean party;
	private int hp; private int maxHp; 
	private int att; private int def; private int exp;

	private Item weapon; private Item armor; private Item ring;
	
	public Unit(String name, int level, int hp, int att, int def, int exp, boolean party) {
		this.name=name;  this.level=level; this.hp=hp; this.maxHp=hp; 
		this.att=att; this.def=def;  this.exp=exp; this.party=party;
	}
	public void setItem(Item weapon, Item armor, Item ring ) {
		this.weapon = weapon; this.armor = armor; this.ring = ring;
	}
	public String getName() {
		return this.name;
	}
	public int getLevel() {
		return this.level;
	}
	public boolean getParty() {
		return this.party;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getAtt() {
		return this.att;
	}
	public int getDef() {
		return this.def; 
	}
	public int getExp() {
		return this.exp;
	}
	public Item getWeapon() {
		return this.weapon;
	}
	public Item getArmor() {
		return this.armor;
	}
	public Item getRing() {
		return this.ring;
	}
	public void setParty(boolean party) {
		this.party = party;
	}
	public void setHp(int hp) {
		this.hp += hp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp += maxHp;
	}
	public void setAtt(int att) {
		this.att += att;
	}
	public void setDef(int def){
		this.def += def;
	}
	public void setExp(int exp) {
		this.exp += exp;
	}
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public void setRing(Item ring ) {
		this.ring = ring;
	}
	public void printUnitStatus() {
		System.out.println("이름 : "+this.name+", 레벨 : "+this.level+", 파티유무 : "+this.party);
		System.out.print("공격력 : "+this.att+", 방어력 : "+this.def);
		if(ring == null) {
			System.out.print(", 체력 : " + hp);
		}
		else {
			System.out.print(", 체력 : " + hp + ring.power);
		}	
		if(ring == null) {
			System.out.println("/" + maxHp);
		}
		else {
			System.out.println("/" + maxHp + ring.power);
		}		
	}
	public void printEquitedItem() {
		if (weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + weapon.name + "]");
		}
		if (armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + armor.name + "]");
		}
		if (ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + ring.name + "]");
		}		
	}

}
