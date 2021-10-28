package zombie2;

public class UnitOrc extends Unit {
	UnitOrc(){
		super.name = "오크녀석";
	}
	void skill() {
		System.out.println("한명에게 2배의 데미지 + 기절");
	}
}
