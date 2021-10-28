package zombie2;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random ran = new Random();
	int monDead = 0;
	int playerDead = 0;

	@Override
	public boolean update() {
		
		return false;
	}

	@Override
	public void init() {
		
		
	}

}
