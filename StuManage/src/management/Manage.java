package management;

public class Manage {
	
	private static Manage instance = new Manage();
	private StuManager stum = StuManager.getInstance(); private SubManager subM = SubManager.getInstance();
	private static int log = -1;
	
	public static Manage getInstance() {
		return instance;
	}
	public static int getLog() {
		return log;
	}
	
	public void run() {
		while(true) {
			System.out.println("[학생관리 시스템]\n1.학생등록 2.학생탈퇴 3.로그인 4.전체학생 조회(과목,점수) 5.종료");
			int sel = this.stum.sc.nextInt();
			if(sel == 1) {
				this.stum.inrollment();
			}else if(sel == 2) {
				this.stum.withdrawal();
			}else if(sel == 3) {
				login();
				if(log != -1) {
					while(log != -1) {
						System.out.println("1.로그아웃 2.수강신청 3.수강철회 4.점수 조회 5.전체 출력");
						int select = this.stum.sc.nextInt();
						if(select == 1) {
							log = -1;
						}else if(select == 2) {
							this.subM.inrollment();
						}else if(select == 3) {
							this.subM.withdrawal();
						}else if(select == 4) {
							this.subM.print();
						}else if(select == 5) {
							this.subM.totalPrint();
						}
					}
				}
			}else if(sel == 4) {
				this.stum.print();
				this.subM.totalPrint();
			}else if(sel ==5) {
				break;
			}
		}
	}
	public void login() {
		this.stum.print();
		System.out.println("name : ");
		String name = this.stum.sc.next();
		System.out.println("student number : ");
		int num = this.stum.sc.nextInt();
		if(this.stum.check(String.valueOf(num))!=-1) {
			log = this.stum.check(String.valueOf(num));
		}
	}
}
