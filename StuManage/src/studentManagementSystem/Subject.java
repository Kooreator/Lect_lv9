package studentManagementSystem;

public class Subject extends Management implements print{
	
	private int score;
	
	public Subject(String name, int num ,int score) {
		super(name, num);
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStuName() {
		return super.getName();
	}
	public int getStuNum() {
		return super.getNum();
	}
	@Override
	public void print() {
		System.out.println("과목명 : "+super.getName() + ", 학번 : " + super.getNum() + ", 점수 :  " + this.score );
	}

}
