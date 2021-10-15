package myGame;

public class Player {
	static int money;
	static Guild guild = Guild.g;
	static Inventory inven = Inventory.instance;
	
	
	public Player() {
		guild.setGuild();
		money = 100000;
	}

}
