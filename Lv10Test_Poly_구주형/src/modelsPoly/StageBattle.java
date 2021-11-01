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
		while(true) {
			if(check_live()) {
				for(int i=0; i<this.monList.size(); i++) {
					if(!this.monList.get(i).getDie()) {
						player_attack(i);						
					}
				}
				for(int i=0; i<this.monList.size(); i++) {
					if(!this.playerList.get(i).getDie()) {
						monster_attack(i);											
					}
				}
				print_Character();
			}else {
				break;
			}
		}
		return false;
	}
	@Override
	public void init() {
		this.monList = null;
		this.playerList = null;
		um.getMonsters().clear();
		um.set_Monster(4);
		this.monList = um.getMonsters();
		this.playerList = um.getPlayers();
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
		System.out.print("\nvs\n== Monsteer ==");
		for(int i=0; i<this.monList.size(); i++) {
			if(!this.monList.get(i).getDie()) {
			this.monList.get(i).print();
			}
		}
	}
	boolean check_live() {
		this.monDie = 0;
		this.playerDie = 0;
		for(int i=0; i<this.playerList.size(); i++) {
			if(this.playerList.get(i).getCur_hp()<=0) {
				this.playerList.get(i).setDie(true);
				this.playerDie++;
			}
		}
		for(int i=0; i<this.monList.size(); i++) {
			if(this.monList.get(i).getCur_hp()<=0) {
				this.monList.get(i).setDie(true);
				this.monDie++;
			}
		}
		if(this.monDie<=4) {
			gm.setCurStage("Battle");
			System.out.println("플래이어가 모두 죽었습니다.");
			return false;
		}else if(this.playerDie<=4) {
			GameManager.nextStage = "Lobby";
			System.out.println("몬스터가 모두 죽었습니다.");
			return false;
		}else {
			return true;
		}
	}
	void player_attack(int index) {
		this.playerList.get(index).attack(this.monList.get(index));
	}
	void monster_attack(int index) {
		while(true) {
			int rNum  =  gm.rn.nextInt(4);
			if(!this.monList.get(rNum).getDie()) {
				this.monList.get(rNum).attack(this.playerList.get(index));
			}
		}
	}

}
