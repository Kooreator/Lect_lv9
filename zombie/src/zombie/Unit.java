package zombie;

public class Unit {
	private static Unit instance = new Unit();
	private String name;  private int hp;
	private int att;      private int def;
	private static int pos = 1;
	Game game = Game.getInstance();
	
	
	protected Unit() {}
	public Unit(String name, int hp ,int att,int def ) {
		this.name=name; this.hp=hp; this.att=att; this.def=def; 
	}
	public static Unit getInstance() {
		if(instance == null) {
			instance = new Unit();
		}
		return instance;
	}
	public static void setInstance(Unit instance) {
		Unit.instance = instance;
	}
	public  Unit getUnit() {
		return getInstance();
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
	
	public void print(){
		System.out.println("[이름] : "+this.name+"  [체력] : "+this.hp);
		System.out.println("[공격력] : "+this.att+"   [방어력] : "+this.def+"  [층] : "+this.pos);
	}
	public int attack(Unit unit) {
		Hero.getInstance().attack(unit);
		// TODO Auto-generated method stub
		return 0;
	}
	

}
