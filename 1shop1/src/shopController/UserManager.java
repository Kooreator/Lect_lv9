package shopController;

import java.util.ArrayList;
import java.util.Random;

import shopMain.Shop;
import shopModels.User;

public class UserManager {
	Random ran = new Random();
	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	
	public void init() {
		String[] a = { "김", "박", "이", "최", "정", "오" };
		String[] b = { "철", "병", "만", "여", "아", "영" };
		String[] c = { "수", "욱", "수", "정", "름", "희" };
		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			User temp = new User(name, ran.nextInt(5000));
			this.users.add(temp);
		}
	}
	
	public UserManager() {
		this.users = new ArrayList<>();
	}
	public ArrayList<User> getUsers(){
		return this.users;
	}
	public void join() {
		System.out.println("id 를 입력하세요.");
		String id = Shop.sc.next();
		if(checkOverlapId(id)) {
			this.users.add(new User(id,10000));
			System.out.println(id+" 님 가입을 축하합니다.");
		}else {
			System.out.println("다시 입력 ");
		}
	}
	public boolean checkOverlapId(String id) {
		for(User u : this.users) {
			if(u.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	public int deleteUser(String id) {
		for(int i=0; i<this.users.size(); i++){
			if(this.users.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	public void Withdrawal() {
		if(this.users.size()!=0) {
			System.out.println("id 를 입력하세요.");
			String id = Shop.sc.next();
			if(!checkOverlapId(id)) {
				this.users.remove(deleteUser(id));	
				System.out.println(id+" 님 탈퇴완료.");
			}			
		}else {
			System.out.println("유저수가 0명입니다.");
		}
	}
	public boolean login() {
		System.out.println("id 를 입력하세요 ");
		String id = Shop.sc.next();
		Shop.log = deleteUser(id);
		if(Shop.log != -1) {
			return true;
		}else {
			return false;
		}
	}public boolean logout() {
		if(Shop.log != -1) {
			Shop.log = -1;
			return true;			
		}else {
			return true;
		}
	}
	public void userPrint() {
		for(int i=0; i<this.users.size(); i++) {
			System.out.print(i+". ");
			this.users.get(i).userPrint();;
		}
	}
	public void creatUser() {
		System.out.print("name : ");
		String name = Shop.sc.next();
		System.out.print("money : ");
		int money = Shop.sc.nextInt();
		this.users.add(new User(name, money));
	}
}
