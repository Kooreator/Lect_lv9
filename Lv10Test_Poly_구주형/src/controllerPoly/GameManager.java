package controllerPoly;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import modelsPoly.Stage;
import modelsPoly.StageBattle;
import modelsPoly.StageLobby;
import modelsPoly.StageTitle;

public class GameManager {
	
	private static GameManager Instance = new GameManager();   private StageBattle sb = new StageBattle();
	public static Random rn = new Random(); public static Scanner sc = new Scanner(System.in);
	public static String nextStage;         private String curStage = "";
	private Map<String , modelsPoly.Stage> stageList = new HashMap<>();
	
	private GameManager() {
		this.stageList.put("Title", new StageTitle());
		this.stageList.put("Lobby", new StageLobby());
		this.stageList.put("Battle", new StageBattle());
		this.nextStage = "Title";
	}
	public static GameManager getInstance() {
		
		return Instance;
	}
	public String getCurStage() {
		return curStage;
	}
	public void setCurStage(String curStage) {
		this.curStage = curStage;
	}
	public boolean play() { 
		
		
		if (nextStage.equals(curStage)) {
			return true;
		}
		this.curStage = nextStage;
		Stage stage = this.stageList.get(curStage);
		stage.update();
		
		while (true) {
			this.curStage = nextStage;
			stage = this.stageList.get(curStage);
			if (!stage.update()) {
				if(nextStage.equals("끝")) {
					System.out.println("game end");
					break;
				}
			}else {
				System.out.println("game end");
				break;
			}
			
		}

		return false;
	}
	
	
	
	

}
