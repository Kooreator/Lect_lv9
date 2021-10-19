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
			System.out.println("==========\n1.공격 2.힐 3.뒤로가기\nselect : ");
			int select = Guild.sc.nextInt();
			if(select == 1) {
				if(this.monsters.size()>0) {
					System.out.println("공격을 실행합니다.");
					guildAttack();	
					if(this.monsters.size()==0) {
						break;
					}
				}
			}else if(select == 2) {
				System.out.println("힐을 실행합니다.");
				guildrecovery();
			}else if(select == 3) {
				this.monsters.remove(0);
				break;
			}
			if(this.monsters.size()>0) {
				System.out.println("Monster에게 공격 당했습니다. !!");
				monsterAttack();				
			}
		}
	}
	public void guildrecovery() {
		for(int i=0; i<this.party.length; i++) {
			if(this.party[i].getHp()<this.party[i].getMaxHp()) {
				this.party[i].setHp(this.party[i].getDef());
				if(this.party[i].getHp()>this.party[i].getMaxHp()) {
					this.party[i].setHp(-this.party[i].getHp());
					this.party[i].setHp(this.party[i].getMaxHp());
				}
			}
		}
		System.out.println("힐을 사용해 길드원들의 hp가 일부 회복되었습니다.");
	}
	public void guildAttack() {
		for(int i=0; i<this.party.length; i++) {
			this.monsters.get(0).setHp(-this.party[i].getAtt());
			if(this.monsters.get(0).getHp()<=0) {
				System.out.println("몬스터사냥에 성공하였습니다.");
				this.monsters.remove(0);
				break;
			}
		}
	}
	public void monsterAttack() {
		int damage = this.monsters.get(0).getAtt();
		for(int i=0; i<this.party.length; i++) {
			this.party[i].setHp(-damage);
			if(this.party[i].getHp()<=0) {
				for(int j=0; j<Guild.g.getGuild().size(); j++) {
					if(this.party[i].equals(Guild.g.getGuild().get(j))) {
						System.out.println("[이름 : "+Guild.g.getGuild().get(j).getName()+"] 파티원 죽음");
						Guild.g.pickUpItem(j);
						this.party[i].setParty(false);
						this.party[i].hpReset();
						Guild.g.getGuild().get(j).setParty(false);
						Guild.g.getGuild().get(j).itemRelease();
						Guild.g.addPartyMember(j);
						Guild.g.setParty();
						System.out.println("========================================");
					}
				}
			}
		}
	}
	public void randomMonsterCreate() {
		int rNum1 = Guild.rn.nextInt(50);
		int rNum2 = Guild.rn.nextInt(10);
		int rNum3 = Guild.rn.nextInt(300);
		this.monsters.add(new Monster(rNum1,rNum2,rNum3));
	}
	public void printMonster() {
		System.out.println("====== 🐗Monster !!🐗 ======");
		for(int i=0; i<this.monsters.size(); i++) {
			this.monsters.get(i).print();
		}
		System.out.println("===============================");
	}
	public void selectBattleParty() {
		System.out.println("");
	}
	
}
