package myGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guild {
	public static Guild g = new Guild();
	public static Random rn = new Random();
	public static Scanner sc = new Scanner(System.in);
	private final int PARTY_SIZE = 4;
	private ArrayList<Unit> guild = new ArrayList<>();
	private Unit [] party;
	public void setGuild() {
		Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0, false);
		guild.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0,false);
		guild.add(temp);
		temp = new Unit("사슴", 1, 50, 3, 1, 0,false);
		guild.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0,false);
		guild.add(temp);
		temp = new Unit("돼지", 1, 200, 4, 8, 0,false);
		guild.add(temp);
		temp = new Unit("사자", 1, 120, 11, 7, 0,false);
		guild.add(temp);
		for(int i=0; i<this.PARTY_SIZE; i++) {
			this.guild.get(i).setParty(true);
		}
		this.party = new Unit[this.PARTY_SIZE];
		setParty();
	}
	public void setParty() {
		int count = 0;
		for(int i=0; i<this.guild.size(); i++) {
			if(this.guild.get(i).getParty()) {
				this.party[count] = this.guild.get(i);
				count++;
			}
		}
	}
	public ArrayList<Unit> getGuild(){
		return this.guild;
	}
	public Unit[] getParty() {
		return this.party;
	}
	public void printAllPartyMember() {
		for(int i=0; i<this.PARTY_SIZE; i++) {
			this.party[i].printUnitStatus();
			System.out.println("");
		}
	}
	public void sortName() {
		for(int i=0; i<this.guild.size(); i++) {
			String first = this.guild.get(i).getName();
			int idx = i;
			for(int j=i; j<this.guild.size(); j++) {
				if(first.compareTo(this.guild.get(j).getName())>0) {
					first = this.guild.get(j).getName();
					idx = j;
				}
			}
			Unit temp = this.guild.get(i);
			this.guild.set(i, this.guild.get(idx));
			this.guild.set(idx, temp);
		}
	}
	public void changePartyMember() {
		printGuild();
		System.out.print("제외할 파티원 번호 선택 : ");
		int delete = g.sc.nextInt()-1;
		if(this.guild.get(delete).getParty()) {
			this.guild.get(delete).setParty(false);			
			System.out.print("합류할 파티원 번호 선택 : ");
			delete = g.sc.nextInt()-1;
			if(!this.guild.get(delete).getParty()) {
				this.guild.get(delete).setParty(true);				
				setParty();
				printAllPartyMember();
			}
		}
	}
	public void printGuild() {
		System.out.println("================ [길드원] ================");
		for(int i=0; i<this.guild.size(); i++) {
			System.out.print("["+(i+1)+" 번]  ");
			this.guild.get(i).printUnitStatus();
			System.out.println("");
		}
		System.out.println("========================================");
	}
	public void creatUnit() {
		String name = "";
		String [] a = {"김","이","박","최","강","구","홍"};
		String [] b = {"가","지","아","정","주","지","은"};
		String [] c = {"형","연","혜","우","숙","연","민"};
		int rNum = g.rn.nextInt(7);
		name += a[rNum];
		rNum = g.rn.nextInt(7);
		name += b[rNum];
		rNum = g.rn.nextInt(7);
		name += c[rNum];
		rNum = g.rn.nextInt(120)+51;
		int at = g.rn.nextInt(12);
		int de = g.rn.nextInt(10);
		Unit temp = new Unit(name,1,rNum,at,de,0,false);
		this.guild.add(temp);
		System.out.println("========================================");
		temp.printUnitStatus();
		System.out.println("길드원을 추가했습니다.");
		System.out.println("========================================");
	}
	public void delete() {
		printGuild();
		System.out.print("삭제할 길드원 번호를 입력하세요 : ");
		int delete = g.sc.nextInt()-1;
		if(0<=delete&&delete<this.guild.size()) {
			System.out.println("[이름 : "+this.guild.get(delete).getName()+"] 길드원 삭제");
			this.guild.remove(delete);
			System.out.println("========================================");
		}
	}

}
