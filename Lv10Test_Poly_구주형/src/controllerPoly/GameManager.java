package controllerPoly;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	
	private static GameManager Instance ;
	public static Random rn = new Random();
	public static Scanner sc = new Scanner(System.in);
	public static String nextStage;
    private String curStage = "";
	private Map<String , modelsPoly.Stage> stageList = new HashMap<>();
	
	private GameManager() {
		
	}
	public static GameManager getInstance() {
		if(Instance == null) {
			Instance = new GameManager();
		}
		return Instance;
	}
	
	
	
	
	

}
