package controllerPoly;

import java.util.ArrayList;
import java.util.Random;

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
	
	
	
	
	

}
