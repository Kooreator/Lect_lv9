package zombie2;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	
	Vector<Player> player_list = new Vector();
	Vector<Unit> mons_list = new Vector();
	String path = "zombie2.";
	String[] mons = {"UnitWolf","UnitOrc","UnitBat"};
	Random rn = new Random();
	
	UnitManager(){
		player_list.add(new Player("힐러",1000,30));
		player_list.add(new Player("마법사",500,100));
		player_list.add(new Player("전사",2000,80));
	}
	
	void monster_rand_set(int size) {
		int rNum = rn.nextInt(mons.length);
		try {
			Class<?> clazz = Class.forName(path+mons[rNum]);
			Object obj = clazz.newInstance();
			Unit temp = (Unit)obj;
			int hp = rn.nextInt(100)+100;
			int power = rn.nextInt(10)+10;
			temp.init(hp, power);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
