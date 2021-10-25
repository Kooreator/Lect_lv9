package zombie;

public class ZombieKing extends Unit implements battle{
	
	private static ZombieKing instance = new ZombieKing();
	private int shield;
	Game game = Game.getInstance();
	
	private ZombieKing() {}
	
	public ZombieKing(String name,int hp,int att,int def,int shield) {
		super(name,hp,att,def);
		this.shield = shield;
	}
	public static ZombieKing getInstance() {
		return instance;
	}
	
	public int getshield() {
		return shield;
	}
	public void setshield(int shield) {
		this.shield = shield;
	}
	@Override
	public int attack(Unit unit) { // 인터페이스 추상 메서드 구현
		if(super.getPos()<20) {
			int att = game.rn.nextInt(60)+1;
			att+=super.getAtt();
			Hero target = (Hero)unit;
			System.out.println("ZombieKing attack damage : "+(att));
			target.setHp(target.getHp()-att);
			if(target.getHp()<=0) {
				System.out.println("용사가 죽었다.");
				target=null;
				target.getInstance().createHero();;
				return 11;
			}
			return 0;
		}
		return 0;
	}
	@Override
	public void print() {// 추상 클래스 추상 메서드 구현
		System.out.println("[이름] : "+super.getName()+"  [체력] : "+super.getHp()+"  [실드] : "+this.shield);
		System.out.println("[공격력] : "+super.getAtt()+"   [방어력] : "+super.getDef()+"  [층] : "+super.getPos());
	}
	public void creatZombieKing() {
		int hp = game.rn.nextInt(200)+100;
		this.shield = game.rn.nextInt(10)+1;
		instance = new ZombieKing("좀비왕",hp,30,20,this.shield);
	}
}
