package controller;

import java.util.ArrayList;

import models.Account;
import models.Bank;
import models.User;

public class UserManager {
	
	private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> account = new ArrayList<>();
	
	
	public static UserManager instance = new UserManager();
	private UserManager() {}
	
	public ArrayList<User> getUsers(){
		return this.users;
	}
	public void join() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		System.out.print("name : ");
		String name = Bank.sc.next();
		this.users.add(new User(ranCode(),id,pw,name,0));
	}
	public void delete() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		int idx = -1;
		for(int i=0; i<this.users.size(); i++) {
			if(id.equals(this.users.get(i).getId())&&pw.equals(this.users.get(i).getPw())) {
				idx = i;
			}
		}
		if(idx == -1) {
			this.users.remove(idx);
		}
	}
	public int ranCode() {
		boolean run = true; int rNum = 0;
		while(true) {
			run = true;
			rNum = Bank.rn.nextInt(1000)+9999;
			for(int i=0; i<this.users.size(); i++) {
				if(this.users.get(i).getUserCode()==rNum) {
					run = false;
				}
			}
			if(run) {
				break;
			}
		}
		return rNum;
	}

}
