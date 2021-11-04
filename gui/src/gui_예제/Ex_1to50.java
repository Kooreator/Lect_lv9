package gui_예제;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
//1 to 50 똑같이 만들기
//ㄴ 타이머 추가
//ㄴ 첫 클릭과 동시에 카운트 시작
//ㄴ 게임 클리어 후, 성적(소요시간 s:ss) 알림창 띄워주기
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.javafx.tk.Toolkit;

class EndTextField extends JTextField{
	
}
class EndLabel extends JLabel{
	
}
class EndFrame extends JFrame{
	
}

class TicToc extends JFrame implements Runnable{
	
	private JLabel timer = new JLabel();
	
	public TicToc() {
		
	}
	
	@Override
	public void run() {
		
		
	}
	
}

class Label extends JLabel{
	
}
class Button extends JButton implements ActionListener{

	public Button(String num,int x , int y, int width ,int height) {
		setLayout(null);
		setText(num);
		setBounds(x, y, width, height);
		setVisible(true);
		revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton)e.getSource();
		
		
	}
}
class Panel extends JFrame{
	Random rn = new Random();
	
	private Button[][] map = new Button[5][5];
	private int [][] mark = new int[5][5];
	
	public Panel() {
		setLayout(null);
		setBounds(50,50,Frame.SIZE-50,Frame.SIZE-50);
		
		
		setMap();
		
		setVisible(true);
		revalidate();
	}
	private void setMap() {
		int x = 30;
		int y = 30;
		
		for(int i=0; i<this.map.length; i++) {
			x += 50 ;
			for(int j=0; j<this.map[i].length; j++) {
				if(this.map[i][j]==null) {
					
					this.map[i][j] = new Button(String.valueOf(this.mark[i][j]),x,y+50*j,30,30);
					this.mark[i][j] = -1; 
					
					
					
				}
			}
		}
		
	}
	private void setRandomMap() {
		for(int i=0; i<this.mark.length; i++) {
			for(int j=0; j<this.mark[i].length; j++) {
				while(true) {
					int rNum = this.rn.nextInt(25)+1;
					if(checkDuplication(rNum)) {
						this.mark[i][j] = rNum;
						break;
					}					
				}
			}
		}
	}
	private boolean checkDuplication(int rNum) {
		int check = -1;
		for(int i=0 ;i<this.mark.length; i++) {
			for(int j=0; j<this.mark[i].length; j++) {
				if(rNum == this.mark[i][j]) {
					check = rNum;
				}
			}
		}
		if(check != -1) {
			return false ;
		}else
			return true;
	}
}	

class Frame extends JFrame{
	
	public static Dimension dm = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private static int width = dm.width;
	private static int height = dm.height;
	
	public static final int SIZE = 1000;
	
	public Frame() {
		
		setLayout(null);
		setTitle("1 to 50");
		setBounds(0, 0, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Panel());
		
		setVisible(true);
		revalidate();
	}
	
}
public class Ex_1to50 {
	public static void main(String[] args) {
		Frame frame = new Frame();
		
	}

}
