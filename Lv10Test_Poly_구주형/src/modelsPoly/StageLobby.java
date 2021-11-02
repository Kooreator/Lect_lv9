package modelsPoly;

import controllerPoly.GameManager;

public class StageLobby extends Stage{

	@Override
	public boolean update() {
		
		System.out.println("1.전투 2.종료");
		int sel  =  GameManager.sc.nextInt();
		
		if(sel == 1) {
			GameManager.nextStage = "Battle";
		}else{
			return true;
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
