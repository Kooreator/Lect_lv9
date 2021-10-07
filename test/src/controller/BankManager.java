package controller;

import models.Bank;

public class BankManager {
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	public BankManager() {}
	
	public UserManager getUserManager() {
		return this.um;
	}
	public void run() {
		while(true) {
			printMenu();
			select();
		}
	}
	public void select() {
		int sel = Bank.sc.nextInt();
		if(Bank.log == -1) {
			if(sel == 1) {
				um.join();
			}else if(sel ==2) {
				um.delete();
			}else if(sel ==3) {
				login();
			}			
		}else if(Bank.log != -1){
			if(sel ==3) {
				logout();
			}else if(sel ==4) {
				am.open();
			}else if(sel ==5) {
				am.delete();
			}else if(sel ==6) {
				am.deposit();
			}else if(sel ==7) {
				am.withdrawl();
			}else if(sel ==8){
				am.transfer();
			}else if(sel ==9) {
				am.print();
			}else if(sel ==10) {
				print();
			}else if(sel ==11) {
				
			}else if(sel ==12) {
				
			}
		}
		print();
	}
	public void printMenu() {
		if(Bank.log == -1) {
			System.out.println("1.회원가입 \n2.탈퇴\n3.로그인");			
		}else {
			System.out.println("3.로그아웃\n4.계좌개설(3개 제한)\n5.계좌철회\n6.입금\n7.출금\n8.이체\n9.전계좌조회\n10.전체 유저,계좌 조회\n11.파일 저장\n12.로드");			
		}
	}
	public void print() {
		for(int i=0; i<this.um.getUsers().size(); i++) {
			this.um.getUsers().get(i).printUserInfo();
			for(int j=0; j<this.um.getUsers().get(i).getAccount().size(); j++) {
				this.um.getUsers().get(i).getAccount().get(j).printInfo();
			}
		}
	}
	public void login() {
		System.out.print("id : ");
		String id = Bank.sc.next();
		System.out.print("pw : ");
		String pw = Bank.sc.next();
		boolean run = false;
		for(int i=0; i<um.getUsers().size(); i++) {
			if(id.equals(um.getUsers().get(i).getId())&&pw.equals(um.getUsers().get(i).getPw())) {
				Bank.log=i;
				run =true;
			}
		}
		if(run) {
			System.out.println("로그인 완료");
		}
	}
	public void logout() {
		Bank.log=-1;
		System.out.println("로그아웃 완료");
	}
}
