package gui_예제;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//과제 : JButton 오목 만들기
//ㄴ 10*10

class ResultPanel extends JPanel{
	
	public ResultPanel() {
		setLayout(null);
		setBounds(0, 0, 400, 300);
		
		setTitle();
		
		
	}

	private void setTitle() {
		
	}
	
}

class ResultFrame extends JFrame{
	
	ResultPanel rp = new ResultPanel();
	
	public ResultFrame() {
		setLayout(null);
		setTitle("Win");
		setBounds(0, 0, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//add();
		
		setVisible(true);
		revalidate();
		
	}
	
}

class OPanel extends JPanel implements ActionListener{
	
	private JLabel title = new JLabel("OMOK") ;
	private ResultFrame result = new ResultFrame();
	
	private int turn = 1 ;
	private boolean isRun ;
	private int winNum ;
	
	private final int SIZE = 10 ;
	private JButton[][] map = new JButton[SIZE][SIZE] ;
	private int[][] mark = new int[SIZE][SIZE] ; 
	
	private Color background = new Color(170, 20, 240) ;
	private Color playerA = new Color(0, 0, 0) ;
	private Color playerB = new Color(238, 238, 238) ;
	
	public OPanel() {
		
		setLayout(null);
		setBounds(0,0,700,800);
		
		setTitle();
		
		setMap();
		
	}
	private void setTitle() {
		this.title.setBounds(0, 0, 700, 100);
		this.title.setForeground(new Color(188, 140, 242));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.BOTTOM);
		this.title.setFont(new Font("TheHung170",Font.PLAIN,40));
		add(this.title);
	}
	
	private void setMap() {
		int x = 700/2-100*SIZE/4;
		int y = 700/2-100*SIZE/4;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new JButton();//인스턴스만 존재(집터)
				
				this.map[i][j].setBounds(x, y, 50, 50);//크기&위치
				
				this.map[i][j].setText("");//간판
				this.map[i][j].setFont(new Font("",Font.PLAIN,20));
				this.map[i][j].setForeground(Color.black);
				this.map[i][j].setBackground(this.background);
				
				//on mac
				this.map[i][j].setOpaque(true);
				this.map[i][j].setBorderPainted(false);
				
				//
				this.map[i][j].addActionListener(this);
				
				add(this.map[i][j]);
				
				x += 50 + 1; 
			}
			x = 700/2 - 100*SIZE/4;
			y += 50 + 1;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.winNum == 0) {
			if(e.getSource() instanceof JButton ) {
				JButton target = (JButton)e.getSource();
				
				for(int i=0;i<SIZE; i++) {
					for(int j=0;j<SIZE; j++) {
						if(mark[i][j]==0) {
							if(this.turn%2==1 && this.map[i][j].equals(target)) {
								this.mark[i][j] = 1;
								target.setBackground(this.playerA);
							}else if(this.turn%2==0 && this.map[i][j].equals(target)) {
								this.mark[i][j] = 2;
								target.setBackground(this.playerB);
							}
						}
					}
				}
				if(wincheck()) { 
					this.winNum=this.turn;
					System.out.printf("p%d 승리!!",this.winNum);
				}else 
			     	this.turn ++;				
			}
		}else {
			//reset??
		}
	}
	
	//00 10 20 30 40 50 60 70 80 90
	//01 11 21 31 41 51 61 71 81 91
	//02 12 22 32 42 52 62 72 82 92
	//03 13 23 33 43 53 63 73 83 93
	//04 14 24 34 44 54 64 74 84 94
	//05 15 25 35 45 55 65 75 85 95
	//06 16 26 36 46 56 66 76 86 96
	//07 17 27 37 47 57 67 77 87 97
	//08 18 28 38 48 58 68 78 88 98
	//09 19 29 39 49 59 69 79 89 99
	
	public boolean wincheck() {
		if(!checkHorizental()) 
			if(checkVertical()) 
				if(checkDiaLR()) 
					if(checkDiaRL()) 
			            return true;
	
		return false ;
	}
	private boolean checkDiaLR() {
		int rel = 5;   
		while(rel>-5) {
			int cnt = 0;
			for(int i=0; i<SIZE-1; i++) {
				for(int j=0; j<SIZE-1; j++) {
					if(i-j==rel && this.mark[i][j] == this.mark[i+1][j+1]) {
						cnt ++;
					}
				}
			}
			if(cnt == 5) {
				return true;
			}
			rel --;
		}
		return false;
	}
	private boolean checkDiaRL() {
		int rel = 4; 
		while(rel<14) {
			int cnt = 0;
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(j+i == rel && this.mark[i][j] == this.mark[i][j]) {
						cnt ++;
					}
				}
			}
			if(cnt == 5) {
				return true;
			}
			rel ++;
		}
		return false;
	}
	private boolean checkVertical() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0; 
			for(int j=0; j<SIZE-1; j++) {
				if(mark[j][i]==0 && mark[j][i]==mark[j+1][i]) {
					cnt ++;
					if(cnt == 5) {
						return true;
					}
				}else {
					cnt =0;
				}
			}
		}
		return false;
	}
	private boolean checkHorizental() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE-1; j++) {
				if(mark[i][j]==0 && mark[i][j]==mark[i][j+1]) {
					cnt ++;
					if(cnt == 5) {
						return true;
					}
				}else {
					cnt = 0;
				}
			}
		}
		return false;
	}
	
}
class Omok extends JFrame{
	
	private OPanel panel = new OPanel();
	
	public Omok() {
		setLayout(null);
		setTitle("Omok");
		setBounds(50, 50, 700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
		
	}
}
public class Ex_오목 {
	public static void main(String[] args) {
		Omok omok = new Omok();
		
	}

}
