package gui_예제;

class PlayGame extends Thread{
	public boolean play;
	private void playGame() {
		
	}
	public void run() {
		play = true;
		
		while(play) {
			System.out.println("신나게 게임을 하는중 >>");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}

class PlayMusic implements Runnable{
	
	boolean play;
	@Override
	public void run() {
		play = true;
		
		while(play) {
			System.out.println("음악이 흐르고 ...");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}

public class Ex02 {
	public static void main(String[] args) {
		PlayGame play = new PlayGame();
		//play.run(); X
//		play.start();
//		
//		int n = 0; 
//		for(int i=0; i<10; n++) {
//			System.out.println("n : "+n );
//			if(n == 8) {
//				System.out.println("앗 엄마가 등장 했다");
//				play.play = false; // play.stop();
//			}
//			
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
		
//		PlayMusic pm = new PlayMusic();
//		
//		pm.run(); //동작 1.
//		
		
		
		
		Runnable music = new PlayMusic();// 동작 2.
		Thread thread = new Thread(music);
		thread.start();
		for(int n=0; n<10; n++) {
			System.out.println("n : "+n);
			if(n == 2) {
				System.out.println("선생님 등장");
				//? stop() Thread 쓰지않고 처리
				if(music instanceof PlayMusic) { //down casting 이 가능한지 검사
					
					PlayMusic stop = (PlayMusic)music;
					stop.play = false;					
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
	}

}
