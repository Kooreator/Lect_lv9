package zombie;

import java.util.*;

public class Game {
	private static Game instance = new Game();   
	Hero hero = Hero.getInstance(); Zombie zombie = Zombie.getInstanece(); ZombieKing zombieKing = ZombieKing.getInstance();
	Scanner sc = new Scanner(System.in);    Random rn = new Random();
	private int run;  private int check;
	
	private Game() {}
	
	public static  Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	public Game getGame() {
		return getInstance();
	}
	
	public void init() {
		if(this.hero.getPos()<5) {
        	this.zombie.creatNomalZombie();
		}else if(this.hero.getPos()<10) {
			this.zombie.creatBigZombie();
		}else if(this.hero.getPos()<15) {
			this.zombie.creatStrongZombie();
		}else if(this.hero.getPos()<20) {
			this.zombieKing.creatZombieKing();
		}
	}
	
	public void run() {
		this.hero.createHero();
		while(run!=10) {
			System.out.printf("[ 현재 층 : %d ]\n",this.hero.getPos());
			System.out.println("[1] : 올라간다.");
			System.out.println("[2] : 체력을 회복한다.");
			System.out.println("[3] : 무기를 강화한다.");
			System.out.print("select : ");
			int select = sc.nextInt();
			if(select == 1) {
				up();
			}else if(select == 2&&this.check==0) {
				this.check = 1;
				this.hero.getInstance().recovery();
			}else if(select == 3&&this.check==0) {
				this.check = 1;
				this.hero.getInstance().upAttackingPower();
			}
		}
		if(run==10) {
			System.out.println("[ game clear!! ]");			
		}else if(run ==11) {
			System.out.println("[ game over .. ");
		}
	}
	
	public void up() {
		this.hero.setPos(this.hero.getPos()+1);
		this.check = 0;
		//System.out.printf("[ 현재 층 : %d ]\n",this.hero.getPos());
		int rNum = rn.nextInt(2);
		init();
		if(rNum == 0) {
			System.out.println("좀비등장");
			run = 0;
			while(run == 0) {
				this.hero.getHero().print();
				System.out.println("==== vs ====");
				if(this.hero.getPos()<15) {
					this.zombie.getInstanece().print();					
				}else {
					this.zombieKing.getInstance().print();;
				}
				System.out.println("============");
				System.out.printf("[선택] \n1.공격 2.물약(%d개 남음)\n",this.hero.getInstance().getBottle());
				int sel = sc.nextInt();
				if(sel == 1) {
					 if(this.hero.getPos()<5) {
				        	run = this.hero.attack(this.zombie.getInstanece());
				        	if(run==0) {				        		
				        		run = this.zombie.attack(this.hero.getInstance());
				        	}
						}else if(this.hero.getPos()<10) {
							run = this.hero.attack(this.zombie.getInstanece());
							if(run==0) {				        		
				        		run = this.zombie.attack(this.hero.getInstance());
				        	}
						}else if(this.hero.getPos()<15) {
							run = this.hero.attack(this.zombie.getInstanece());
							if(run==0) {				        		
				        		run = this.zombie.attack(this.hero.getInstance());
				        	}
						}else if(this.hero.getPos()<20) {
							run = this.hero.attack(this.zombieKing.getInstance());
							if(run==0) {				        		
				        		run = this.zombie.attack(this.hero.getInstance());
				        	}
						}
				}else if(sel ==2) {
					this.hero.getInstance().takeBottle();
					if(this.hero.getPos()<5) {				        		
			        		run = this.zombie.attack(this.hero.getInstance());
					}else if(this.hero.getPos()<10) {
			        		run = this.zombie.attack(this.hero.getInstance());
					}else if(this.hero.getPos()<15) {
			        		run = this.zombie.attack(this.hero.getInstance());
					}else if(this.hero.getPos()<20) {
			        		run = this.zombie.attack(this.hero.getInstance());
					}
				}
			}
		}else if(rNum == 1) {			
			System.out.println("좀비가 없는 층이다.");
		}
	}
}
