package management;

import java.util.ArrayList;

import studentManagementSystem.Subject;

public class SubManager implements Manager{
	
	private static SubManager instance = new SubManager();
	private ArrayList<Subject> subjects = new ArrayList<>();
	
	public static SubManager getInstance() {
		return instance;
	}
	public ArrayList<Subject> getSubjects(){
		return this.subjects;
	}
	
	public void inrollment() {
		System.out.println("신청할 과목명 입력 : ");
		String name = StuManager.getInstance().sc.next();
		int num = StuManager.getInstance().getStudent().get(Manage.getLog()).getStuNum();
		int score = StuManager.getInstance().rn.nextInt(101);
		this.subjects.add(new Subject(name,num,score));
	}
	public void withdrawal() {
		System.out.println("철회할 과목명 : ");
		String name = StuManager.getInstance().sc.next();
		if(check(name)!=-1) {
			this.subjects.remove(check(name));
		}
		
	}
	public int check(String name) {
		for(int i=0; i<this.subjects.size(); i++) {
			if(this.subjects.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public void print() {
		System.out.println("=== 현재 로그인 학생 과목,점수 현황 ===");
		int num = StuManager.getInstance().getStudent().get(Manage.getLog()).getStuNum();
		for(int i=0; i<this.subjects.size(); i++) {
			if(num == this.subjects.get(i).getStuNum()) {
				this.subjects.get(i).print();				
			}
		}
		System.out.println("===============================");
	}
	public void totalPrint() {
		System.out.println("=== total Subject Info ===");
		for(int i=0; i<this.subjects.size(); i++) {
			this.subjects.get(i).print();
		}
		System.out.println("===============================");
	}
	

}
