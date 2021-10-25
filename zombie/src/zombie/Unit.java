package zombie;

abstract class Unit {
	
	private String name;  private int hp;
	private int att;      private int def;
	private static int pos = 1;
	Game game = Game.getInstance();
	
	
	protected Unit() {}
	public Unit(String name, int hp ,int att,int def ) {
		this.name=name; this.hp=hp; this.att=att; this.def=def; 
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public int getAtt() {
		return this.att;
	}
	public int getDef() {
		return this.def;
	}
	public int getPos() {
		return this.pos;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setAtt(int att) {
		this.att=att;
	}
	public void setDef(int def) {
		this.def=def;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public abstract void print();
	
	public int attack(Unit unit) {
		Hero.getInstance().attack(unit);
		// TODO Auto-generated method stub
		return 0;
	}
	

}
