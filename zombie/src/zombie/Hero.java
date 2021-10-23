package zombie;

public class Hero extends Unit implements battle{
	
	private static Hero instance = new Hero();
	private int bottle = 3;
	Game game = Game.getInstance();
	
	private Hero() {}
	
	
	public Hero(String name, int hp, int att, int def) {
		super(name, hp, att, def);
		// TODO Auto-generated constructor stub
	}

	public static Hero getInstance() {
		return instance;
	}
	
	public Hero getHero() {
		return instance;
	}
	public int getBottle() {
		return this.bottle;
	}
	public void setBottle(int bottle) {
		this.bottle = bottle;
	}
	
	public void createHero() {
		instance = new Hero("용사",100,5,1);
	}
	public int attack(Unit unit) {
		if(super.getPos()<5) {
			int att = game.rn.nextInt(30)+1;
			att+=super.getAtt();
			Zombie target = (Zombie)unit;
			System.out.println("Hero attack damage : "+(att));
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("좀비를 물리쳤다!!");
				target=null;
				target.getInstanece().creatNomalZombie();
				return 9;
			}
			return 0;
		}else if(super.getPos()<10) {
			int att = game.rn.nextInt(30)+1;
			att +=super.getAtt();
			Zombie target = (Zombie)unit;
			System.out.println("Hero attack damage : "+att);
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("좀비를 물리쳤다!!");
				target=null;
				target.getInstanece().creatBigZombie();;
				return 9;
			}
			return 0;
		}else if(super.getPos()<15) {
			int att = game.rn.nextInt(30)+1;
			att += super.getAtt();
			Zombie target = (Zombie)unit;
			System.out.println("Hero attack damage : "+att);
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("좀비를 물리쳤다!!");
				target=null;
				target.getInstanece().creatStrongZombie();;
				return 9;
			}
			return 0;
		}else if(super.getPos()<20) {
			int att = game.rn.nextInt(30)+1;
			att += super.getAtt();
			ZombieKing target = (ZombieKing)unit;
			System.out.println("Hero attack damage : "+att);
			if(target.getshield()!=0) {
				target.setshield(target.getshield()-1);
			}else {
				target.setHp(target.getHp()-att);
				if(target.getHp()<=0) {
					System.out.println("좀비왕을 물리쳤다!!");
					target=null;
					target.getInstance().creatZombieKing();
					return 10;
				}			
			}
			return 0;
		}
		return 0;
	}
	
	@Override
	public void print() {
		super.print();		
	}
	public void takeBottle() {
		super.setHp(getHp()+300);
		this.bottle--;
	}
	public void recovery() {
		int hp = this.game.getGame().rn.nextInt(300)+1;
		super.setHp(getHp() + hp); 
		System.out.printf("채력이 %d 증가했다.",hp);
	}
	public void upAttackingPower() {
		int hp = game.getGame().rn.nextInt(20);
		super.setAtt(getAtt()+hp);
		System.out.printf("공격력 %d 증가했다",hp);
	}

}
