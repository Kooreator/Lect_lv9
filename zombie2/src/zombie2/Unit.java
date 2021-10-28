package zombie2;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "nomal";
	
	Unit(){}
	Unit(String name, int maxhp, int power){
		this.name = name;
		this.maxhp = maxhp;
		this.curhp = maxhp;
		this.power = power;
	}
	
	void init(int max ,int power) {
		this.maxhp = max;
		this.curhp = max;
		this.power= power;
	}
	void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	}
	void attack(Unit target) {
		target.curhp -= power;
		System.out.printf("[ %s ] 이 [ %s ] 에게 %d 의 데미지를 입힙니다.",this.name,target.name,this.power);
		if(target.curhp <= 0) {
			System.out.printf("[ %s ] 이 죽었습니다." );
			target.curhp = 0;
		}
	}
	void printData() {
		System.out.printf("[ %s ]  [ %d/%d ] [ %d ]",this.name,this.curhp,this.maxhp,this.power);
	}

}
