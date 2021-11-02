package controllerPoly;
//시작 : 18:10
//종료 : 03:00
//소요 : 09:00
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		if(gm.play()) {
			System.out.println("game end");			
		}
	}

}
