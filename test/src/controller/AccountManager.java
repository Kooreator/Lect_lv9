package controller;

import java.util.ArrayList;

import models.Account;
import models.Bank;

public class AccountManager {
	private BankManager bm = new BankManager();
	
	public static AccountManager instance = new AccountManager();
	public AccountManager() {}
	
	public int ranCode() {
		boolean run = true; int rNum = 0;
		while(true) {
			run = true;
			rNum = Bank.rn.nextInt(100)+999;
			for(int i=0; i<this.bm.getUserManager().getUsers().get(Bank.log).getAccount().size(); i++) {
				if(this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(i).getAccNum()==rNum) {
					run = false;
				}
			}
			if(run) {
				break;
			}
		}
		return rNum;
	}
	public void open() {
		if(this.bm.getUserManager().getUsers().get(Bank.log).getAccCnt()<3) {
			this.bm.getUserManager().getUsers().get(Bank.log).getAccount().add(new Account(ranCode(),0));
			this.bm.getUserManager().getUsers().get(Bank.log).setAccCnt(1);			
		}
	}
	public void delete() {
		if(this.bm.getUserManager().getUsers().get(Bank.log).getAccCnt()>1) {
			System.out.print("계좌번호 : ");
			int num = Bank.sc.nextInt(); int idx = -1;
			for(int i=0; i<bm.getUserManager().getUsers().get(Bank.log).getAccount().size(); i++) {
				if(num == bm.getUserManager().getUsers().get(Bank.log).getAccount().get(i).getAccNum()) {
					idx = i;
				}
			}
			if(idx != -1) {
				this.bm.getUserManager().getUsers().get(Bank.log).getAccount().remove(idx);
				this.bm.getUserManager().getUsers().get(Bank.log).setAccCnt(-1);			
			}
		}
	}
	public int check() {
		System.out.print("계좌번호 : ");
		int accNum = Bank.sc.nextInt();
		int idx = -1;
		for(int i=0; i<this.bm.getUserManager().getUsers().get(Bank.log).getAccount().size(); i++) {
			if(this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(i).getAccNum()==accNum) {
				idx = i;
			}
		}
		if(idx != -1) {
			return idx;
		}else {
			return idx;
		}
	}
	public void deposit() {
		int idx = check();
		if(idx != -1) {			
			System.out.print("금액 : ");
			int gold = Bank.sc.nextInt();
			this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(idx).setMoney(gold);
		}
	}
	public void withdrawl() {
		int idx = check();
		if(idx != -1) {	
			System.out.print("금액 : ");
			int gold = Bank.sc.nextInt();
			if(this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(idx).getMoney()>=gold) {
				this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(idx).setMoney(-gold);							
			}
		}	
	}
	public void transfer() {
		int idx = check();
		if(idx != -1) {	
			System.out.print("이체할 계좌번호 : ");
			int accNum = Bank.sc.nextInt();
			int idx1 = 0; int idx2 = 0;
			for(int i=0; i<this.bm.getUserManager().getUsers().size(); i++) {
				for(int j=0; j<this.bm.getUserManager().getUsers().get(i).getAccount().size(); j++) {
					if(accNum == this.bm.getUserManager().getUsers().get(i).getAccount().get(j).getAccNum()) {
						idx1 = i; idx2 = j;
					}
				}
			}
			if(idx2 != -1) {
				System.out.print("금액 : ");
				int gold = Bank.sc.nextInt();
				this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(idx).setMoney(-gold);
				this.bm.getUserManager().getUsers().get(idx1).getAccount().get(idx2).setMoney(gold);
			}
		}
	}
	public void print() {
		for(int i=0; i<this.bm.getUserManager().getUsers().get(Bank.log).getAccount().size(); i++) {
			this.bm.getUserManager().getUsers().get(Bank.log).getAccount().get(i).printInfo();
		}
	}
	

}
