package myGame;

public class Player {
	public static Player instance = new Player();
	int money;
	//Guild guild = Guild.g;
	Inventory inventory = Inventory.instance;
	
	
	public Player() {
		money = 100000;
	}

}
