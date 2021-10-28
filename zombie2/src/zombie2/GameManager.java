package zombie2;
import java.util.*;
public class GameManager {

	public static Random rn = new Random();
	public static Scanner sc = new Scanner(System.in);
	public static String nextStage = "";
	String curStage = "";
	Map<String , Stage> stageList = new HashMap<String, Stage>();
	
	GameManager(){
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	

}
