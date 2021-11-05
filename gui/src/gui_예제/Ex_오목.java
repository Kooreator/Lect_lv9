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




class OPanel extends JPanel implements ActionListener,Runnable{
	
	private JLabel title = new JLabel("OMOK") ;
	
	private int ms ;
	private boolean isRun ;
	private int gameNum = 1;
	
	private final int SIZE = 10;
	private JButton[][] map = new JButton[SIZE][SIZE] ;
	private int[][] mark = new int[SIZE][SIZE] ; 
	
	private Color background = new Color(170, 20, 240);
	private Color playerA = new Color(0, 0, 0);
	private Color playerB = new Color(238, 238, 238);
	
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
		this.title.setFont(new Font("TheHung170",Font.PLAIN,20));
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
				this.map[i][j].setFont(new Font("TheHung170",Font.PLAIN,20));
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
	public void run() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton ) {
			JButton target = (JButton)e.getSource();
			
		}
		
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
