package shopController;

import java.util.ArrayList;

import shopMain.Shop;
import shopModels.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	
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
			this.users.add(new User(id));
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
		System.out.println("id 를 입력하세요.");
		String id = Shop.sc.next();
		if(!checkOverlapId(id)) {
			this.users.remove(deleteUser(id));	
			System.out.println(id+" 님 탈퇴완료.");
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
}
