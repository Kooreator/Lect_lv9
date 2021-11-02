package controllerPoly;

import java.util.ArrayList;
import java.util.Random;

import modelsPoly.Player;
import modelsPoly.Unit;
import modelsPoly.UnitBat;
import modelsPoly.UnitOrc;
import modelsPoly.UnitWolf;

public class UnitManager {
	
	private static UnitManager instance = new UnitManager();
	private Random rn = new Random();
	private ArrayList<modelsPoly.Player> players = new ArrayList<modelsPoly.Player>();
	private ArrayList<modelsPoly.Unit> monsters = new ArrayList<>();
	private String[] mons = {"UnitBat","UnitOrc","UnitWolf"};
	private String path = "modelsPoly.";
	
	private UnitManager() {
		this.players.add(new modelsPoly.Player("전사",100,100));
		this.players.add( new modelsPoly.Player("마법사",200,200));
		this.players.add(new modelsPoly.Player("힐러",100,100));
	}
	public static UnitManager getInstance() {
		if(instance == null) {
			instance = new UnitManager();
		}
		return instance;
	}
	
	public ArrayList<modelsPoly.Unit> getMonsters() {
		return monsters;
	}
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public void set_Monster(int size) {
		
		for(int i=0;i<size ; i++) {
			int rNum = this.rn.nextInt(this.mons.length);
			int rHp = this.rn.nextInt(150) + 100;
			int rPower = this.rn.nextInt(50) + 10;
			Unit temp = null;
			if(rNum == 0) {
				temp = new UnitBat(this.mons[rNum],rHp,rPower);
			}else if(rNum == 1) {				
				temp = new UnitOrc(this.mons[rNum],rHp,rPower);				
			}else if(rNum == 2) {
				temp = new UnitWolf(this.mons[rNum], rHp, rPower);
			}
			this.monsters.add(temp);
		}
	}
	
	
	
	
	

}
