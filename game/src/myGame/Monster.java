package myGame;

public class Monster {
	
	private int att;  private int def; private int hp;
	
	public Monster(int att, int def, int hp) {
		this.att=att; this.def=def; this.hp=hp+def;
	}
	public int getAtt() {
		return this.att;
	}
	public int getDef() {
		return this.def;
	}
	public int getHp() {
		return this.hp;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public void setDef(int def) {
		this.def=def;
	}
	public void setHp(int hp) {
		this.hp=this.hp+hp;
	}
	public void print() {
		System.out.printf("[공격력 %d] [방어력 %d] [HP %d]\n",this.att,this.def,this.hp);
	}
	public void monsterInitialization() {
		
		
	}

}
