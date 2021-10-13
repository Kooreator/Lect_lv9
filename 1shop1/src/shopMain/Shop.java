package shopMain;

import java.util.Random;
import java.util.Scanner;

import shopController.CategoryManager;
import shopController.Manager;
import shopController.UserManager;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	public static Random rn = new Random();
	
	public static int log = -1;
	
	private void mainMenu() {
		System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃] [100.관리자]");
	}
	public void selectMenu() {
		int select = sc.nextInt();
		if(select == 1) {
			UserManager.instance.join();
		}else if(select == 2) {
			UserManager.instance.Withdrawal();
		}else if(select == 3) {
			if(UserManager.instance.login()) {
				System.out.println("login !!");
				mainSelectMenu();
			}else {
				System.out.println("login X ");
			}
		}else if(select == 4) {
			if(UserManager.instance.logout()) {
				System.out.println("logout !!");
			}
		}else if(select == 100) {
			Manager.instance.selectManageerMenu();
		}
	}
	public void mainSelectMenu() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
			int select = sc.nextInt();
			if(select == 1) {
				shopSelectMenu();
			}else if(select == 2) {
				UserManager.instance.getUsers().get(log).cartList();
			}else if(select == 3) {
				break;
			}			
		}
	}
	public void shopSelectMenu() {
		while(true) {
			CategoryManager.instance.categoryprint();
			System.out.println("[카테고리] 번호를 입력하세요.[종료.-1]");
			int select = sc.nextInt();
			CategoryManager.instance.selectCategoryMenu(select);
		}
	}
	public void run() {
		while(true){
			mainMenu();
			selectMenu();
		}
	}
	

	

}
