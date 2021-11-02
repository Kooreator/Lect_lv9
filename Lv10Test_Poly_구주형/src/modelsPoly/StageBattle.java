package modelsPoly;

import java.util.ArrayList;

import controllerPoly.GameManager;
import controllerPoly.UnitManager;


public class StageBattle extends Stage{
	
	GameManager gm = GameManager.getInstance();
	private UnitManager um = UnitManager.getInstance();
	private ArrayList<Unit> monList = new ArrayList<>();
	private ArrayList<Player> playerList = new ArrayList();
	private int monDie;     private int playerDie;
	
	@Override
	public boolean update() {
		init();
		print_Character();
		while (check_live()) {
			System.out.println("1.공격");
			int num = gm.sc.nextInt();
			if(num == 1) {
				System.out.println("======================");
				for (int i = 0; i < this.monList.size(); i++) {
					if (!this.monList.get(i).getDie()) {
						player_attack(i);
					}
				}
				for (int i = 0; i < this.playerList.size(); i++) {
					if (!this.playerList.get(i).getDie()) {
						monster_attack(i);
					}
				}
				System.out.println("======================");
				print_Character();				
			}
		}
		
		return false;
	}
	@Override
	public void init() {
		um.getMonsters().clear();
		um.set_Monster(4);
		System.out.println(um.getMonsters().size());
		this.playerList = null;
		this.playerList = um.getPlayers();
		this.monList = null;
		this.monList = um.getMonsters();
		this.monDie = um.getMonsters().size();
		this.playerDie = um.getPlayers().size();
	}
	void print_Character() {
		System.out.println("=== Player ===");
		for(int i=0; i<um.getPlayers().size(); i++) {
			if(!this.playerList.get(i).getDie()) {
				um.getPlayers().get(i).print();				
			}
		}
		System.out.print("vs\n== Monsteer ==\n");
		for(int i=0; i<um.getMonsters().size(); i++) {
			if(!this.monList.get(i).getDie()) {
			um.getMonsters().get(i).print();
			}
		}
	}
	boolean check_live() {
		this.monDie = 4;
		this.playerDie = 3;
		for(int i=0; i<this.playerList.size(); i++) {
			if(this.playerList.get(i).getCur_hp()<=0) {
				this.playerList.get(i).setDie(true);
				this.playerDie--;
			}
		}
		for(int i=0; i<this.monList.size(); i++) {
			if(this.monList.get(i).getCur_hp()<=0) {
				this.monList.get(i).setDie(true);
				this.monDie--;
			}
		}
		System.out.println(this.monDie);
		System.out.println(this.playerDie);
		if(this.monDie==0) {
			GameManager.nextStage = "Lobby";
			System.out.println("몬스터가 모두 죽었습니다.");
			return false;
		}else if(this.playerDie==0) {
			GameManager.nextStage = "끝";
			System.out.println("플래이어가 모두 죽었습니다.");
			return false;
		}else {
			return true;
		}
	}

	void player_attack(int index) {
		int cnt = 0;
		while (true) {
			int rNum = gm.rn.nextInt(3);
			if (!this.playerList.get(rNum).getDie()) {
				this.playerList.get(rNum).attack(this.monList.get(index));
				break;
			}
			cnt ++;
			if(cnt== 10) {
				break;
			}
		}
	}

	void monster_attack(int index) {
		int cnt = 0;
		while (true) {
			int rNum = gm.rn.nextInt(4);
			if (!this.monList.get(rNum).getDie()) {
				this.monList.get(rNum).attack(this.playerList.get(index));
				break;
			}
			cnt ++;
			if(cnt== 10) {
				break;
			}
		}
	}

}
