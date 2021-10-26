package studentManagementSystem;

public class Student extends Management implements print{
	
	public Student(String name, int num) {
		super(name, num);
	}
	
	public int getStuNum() {
		return super.getNum();
	}
	public String getStuName() {
		return super.getName();
	}
	public void print() {
		System.out.println("이름 : "+super.getName() + ", 학번 : " + super.getNum() );
	}

}
