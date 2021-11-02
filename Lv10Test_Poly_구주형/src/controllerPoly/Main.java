package controllerPoly;
//시작 : 00:00
//종료 : 00:00
//소요 : 00:00
public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		if(gm.play()) {
			System.out.println("game end");			
		}
	}

}
