package models;

import java.util.*;

public class Bank {
	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();
	public static int log = -1;
	
	private static String bankName;
	
	private Bank() {} // new 를 통한 Bank 생성이 안되게 막음
	
	public static String getName() {
		return Bank.bankName;
	}
	public static void setBankName(String bankName) {
		Bank.bankName = bankName;
	}

}
