package controllerPoly;

import java.util.ArrayList;
import java.util.Random;

import modelsPoly.Player;
import modelsPoly.Unit;

public class UnitManager {
	
	private static UnitManager instance;
	private Random rn = new Random();
	private ArrayList<modelsPoly.Player> players = new ArrayList<modelsPoly.Player>();
	private ArrayList<modelsPoly.Unit> monsters = new ArrayList<>();
	private String[] mons = {"UnitBat","UnitOrc","UnitWolf"};
	private String path = "zombie3.";
	
	private UnitManager() {
		this.players.add(new modelsPoly.Player("전사",300,300));
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
			
			try {
				Class<?> clazz = Class.forName(path+this.mons[rNum]);
				Object obj = clazz;
				Unit temp = (Unit)obj;
				int rHp = this.rn.nextInt(150);
				int rPower = this.rn.nextInt(150);
				temp.init(this.mons[rNum],rHp,rPower);
				this.monsters.add(temp);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
	

}
