package myGame;

import java.util.ArrayList;

public class Battle {
	
	public static Battle instance = new Battle();
	private ArrayList<Monster> monsters = new ArrayList<>();
	private Unit[] party = Guild.g.getParty();
	
	public ArrayList<Monster> getMonsters(){
		return this.monsters;
	}
	public void hunting() {
		randomMonsterCreate();
		while(true) {
			printMonster();
			Guild.g.printAllPartyMember();
			System.out.println("1.공격 2.힐");
			int select = Guild.sc.nextInt();
			if(select == 1) {
				
			}else if(select == 2) {
				
			}
			System.out.println("Monster에게 공격 당했습니다. !!");
			monsterAttack();
		}
	}
	public void guildAttack() {
		
	}
	public void monsterAttack() {
		int damage = this.monsters.get(0).getAtt();
		for(int i=0; i<this.party.length; i++) {
			this.party[i].setHp(damage);
		}
	}
	public void randomMonsterCreate() {
		int rNum1 = Guild.rn.nextInt(50);
		int rNum2 = Guild.rn.nextInt(10);
		int rNum3 = Guild.rn.nextInt(300);
		this.monsters.add(new Monster(rNum1,rNum2,rNum3));
	}
	public void printMonster() {
		for(int i=0; i<this.monsters.size(); i++) {
			this.monsters.get(i).print();
		}
	}
	public void selectBattleParty() {
		System.out.println("");
	}
	
}
