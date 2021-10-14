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
	public void creatUnit() {
		String [] a = {"김","이","박","최","강","구","홍"};
		String [] b = {"가","지","아","정","주","지","은"};
		String [] c = {"형","연","혜","우","숙","연","민"};
		
	}

}
