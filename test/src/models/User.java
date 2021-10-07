package models;

import java.util.ArrayList;

public class User {
	private ArrayList<Account> account = new ArrayList<>();
	
	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	public User(int userCode , String id,String pw,String name, int accCnt) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.accCnt = accCnt;
	}
	public ArrayList<Account> getAccount(){
		return this.account;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public int getAccCnt() {
		return this.accCnt;
	}
	public int getUserCode() {
		return this.userCode;
	}
	public void setAccCnt(int accCnt) {
		this.accCnt=this.accCnt+accCnt;
	}
	public void printUserInfo() {
		System.out.println(this.userCode+" : "+this.id+" : "+this.pw+" : "+this.name+" : "+this.accCnt);
	}

}
