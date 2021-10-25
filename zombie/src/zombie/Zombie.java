package zombie;

public class Zombie extends Unit implements battle{
	
	private static Zombie instance = new Zombie();
	Game game = Game.getInstance();

	private Zombie() {}
	
	public Zombie(String name, int hp, int att, int def) {
		super(name, hp, att, def);
	}
	
	public static Zombie getInstanece() {
		return instance;
	}
	
	public int attack(Unit unit) {
		if(super.getPos()<5) {
			int att = game.rn.nextInt(10)+1;
			att+=super.getAtt();
			Hero target = (Hero)unit;
			System.out.println("Zombie attack damage : "+(att));
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("용사가 죽었다.");
				target=null;
				target.getInstance().createHero();;
				return 11;
			}
			return 0;
		}else if(super.getPos()<10) {
			int att = game.rn.nextInt(25)+1;
			att +=super.getAtt();
			Hero target = (Hero)unit;
			System.out.println("Zombie attack damage : "+att);
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("좀비를 물리쳤다!!");
				target=null;
				target.getInstance().createHero();;
				return 11;
			}
			return 0;
		}else if(super.getPos()<15) {
			int att = game.rn.nextInt(40)+1;
			att += super.getAtt();
			Hero target = (Hero)unit;
			System.out.println("Zombie attack damage : "+att);
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("좀비를 물리쳤다!!");
				target=null;
				target.getInstance().createHero();;
				return 11;
			}
			return 0;
		}
		return 0;
	}
	public void creatNomalZombie(){
		int hp = game.rn.nextInt(25)+1;
		instance = new Zombie("그냥좀비",hp,5,1);
	}
	public void creatBigZombie() {
		int hp = game.rn.nextInt(50)+26;
		instance = new Zombie("덩치 큰 좀비",hp,10,5);
	}
	public void creatStrongZombie() {
		int hp = game.rn.nextInt(100)+50;
		instance = new Zombie("힘쎈 좀비",hp,20,10);
	}

	@Override
	public void print() {
		System.out.println("[이름] : "+super.getName()+"  [체력] : "+super.getHp());
		System.out.println("[공격력] : "+super.getAtt()+"   [방어력] : "+super.getDef()+"  [층] : "+super.getPos());
		
	}

}
