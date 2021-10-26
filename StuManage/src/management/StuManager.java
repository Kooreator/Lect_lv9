package management;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import studentManagementSystem.Student;

public class StuManager implements Manager{
	
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	private static StuManager instance = new StuManager();
	private ArrayList<Student> students = new ArrayList<>();
	
	
	public static StuManager getInstance() {
		return instance;
	}
	public ArrayList<Student> getStudent(){
		return this.students;
	}
	public void inrollment() {
		System.out.print("Student name : ");
		String name = this.sc.next();
		this.students.add(new Student(name, createStuNum()));
	}
	public void withdrawal() {
		print();
		System.out.print("삭제할 학생의 학번 입력 : ");
		int num = this.sc.nextInt();
		if(check(String.valueOf(num))!=-1) {
			this.students.remove(String.valueOf(num));			
		}
	}
	public int createStuNum() {
		while(true) {
			int check = -1;
			int num = rn.nextInt(9999)+1001;
			for(int i=0; i<this.students.size(); i++) {
				if(this.students.get(i).getNum()==num) {
					check = 1;
				}
			}
			if(check == -1) {
				return num;
			}
		}
	}
	public void print() {
		System.out.println("==== 학생정보 현황 ====");
		for(int i=0; i<this.students.size(); i++) {
			this.students.get(i).print();
		}
		System.out.println("====================");
	}
	public int  check(String num) {
		for(int i=0; i<this.students.size(); i++) {
			if(this.students.get(i).getNum()== Integer.parseInt(num)) {
				return i;
			}
		}
		return -1;
	}
	
	
	

}
