package modelsPoly;

public abstract class Unit {
	private String name;
	private int max_hp;
	private int cur_hp;
	private int power;
	private boolean die;
	
	Unit(){}
	Unit(String name , int max_hp , int power ){
		this.name = name;
		this.max_hp = max_hp;
		this.cur_hp = max_hp;
		this.power = power;
	}
	public void init(String name, int max_hp,int power){
		this.name = name;
		this.cur_hp = max_hp;
		this.max_hp = max_hp;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	public int getMax_hp() {
		return max_hp;
	}
	public int getCur_hp() {
		return cur_hp;
	}
	public int getPower() {
		return power;
	}
	public Boolean getDie() {
		return die;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCur_hp(int cur_hp) {
		this.cur_hp = cur_hp;
	}
	public void setDie(boolean die) {
		this.die = die;
	}
	 
	void print() {
		System.out.printf("[이름 : %s] [hp : %d/%d] [power : %s]\n",this.name,this.cur_hp,this.max_hp,this.power);
	}
	public void attack(Unit target) {
		if(!target.die) {
			target.cur_hp-=this.power;			
			if(target.cur_hp <= 0) {
				target.cur_hp = 0;
				target.die = true;
				System.out.printf("[%s] 이 [%s] 에게 공격받아 죽었습니다.",target.name,this.name);
			}else {
				System.out.printf("[%s] 이 [%s] 에게 [%d]데미지를 주었습니다.",this.name,target.name,this.power);				
			}
		}
	}
	

}
