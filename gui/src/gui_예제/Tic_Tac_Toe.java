//package gui_예제;
//
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//
//
//
//class ResultGame extends JPanel{
//	public ResultGame() {
//		
//	}
//}
//
//
//class Game extends JPanel implements ActionListener {
//	private JButton[] map = new JButton[9];
//	private int[] mark = new int[9];
//	
//	private int turn = 1 ;
//	private int win;
//	
//	private JLabel title = new JLabel("틱 택 토 ");
//	
//	
//	public Game() {
//		setLayout(null);
//		setBounds(0, 0,Frame.SIZE,Frame.SIZE );
//		
//		setTitle();
//		setMap();
//	}
//	
//
//	private void setMap() {
//		int x = 200;
//		int y = 200;
//		
//		for(int i=0; i<this.map.length ; i++) {
//			this.map[i] = new JButton();
//			this.map[i].setBounds(x, y, 100, 100);
//			
//			//on mac
//			this.map[i].setOpaque(true);
//			this.map[i].setBorderPainted(false);
//			this.map[i].setBackground(new Color(255, 155, 106));
//			
//			this.map[i].addActionListener(this);
//			add(this.map[i]);
//			
//			
//		}
//		
//	}
//
//
//	private void setTitle() {
//		this.title.setBounds(0,0,100,100);
//		this.title.setFont(new Font("BM JUA_OTF",Font.BOLD,40));
//		this.title.setHorizontalAlignment(JLabel.CENTER);
//		this.title.setVerticalAlignment(JLabel.BOTTOM);
//		add(this.title);
//	}
//
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton target = (JButton)e.getSource();
//		
//		for(int i=0; i<this.map.length; i++) {
//			if(target == this.map[i] && this.mark[i] == 0) {
//				
//				if(this.turn == 1)
//					target.setBackground(new Color(255, 81, 81));
//				else
//					target.setBackground(new Color(22, 30, 84));
//				
//				this.mark[i] = this.turn;
//				checkWin();
//				this.turn = this.turn == 1 ? 2:1;
//			}
//		}
//	}
//
//
//	private void checkWin() {
//		this.win = this.win == 0 ? checkHori() : this.win;
//		this.win = this.win == 0 ? checkVerti() : this.win;
//		this.win = this.win == 0 ? checkDia() : this.win;
//		this.win = this.win == 0 ? checkReverse() : this.win;
//		
//		
//		
//	}
//
//
//	private int checkReverse() {
//		int cnt = 0;
//		for(int i=0; i<9; i+=4) {
//			if(this.mark[i]==this.turn) {
//				cnt ++;
//			}
//		}
//		if(cnt == 3) {
//			return this.turn;
//		}
//		return 0;
//	}
//	private int checkDia() {
//		int cnt = 0;
//		for(int i=2; i<7; i+=2) {
//			if(this.mark[i]==this.turn) {
//				cnt ++;
//			}
//		}
//		if(cnt == 3) {
//			return this.turn;
//		}
//		return 0;
//	}
//	private int checkVerti() {
//		for(int i=0; i<3; i++) {
//			int cnt = 0;
//			for(int j=0; i<9; j+=3) {
//				if(this.mark[i+j] == this.turn) {
//					cnt ++;
//				}
//			}
//			if(cnt == 3) {
//				return this.turn;
//			}
//		}
//		return 0;
//	}
//	private int checkHori() {
//		for(int i=0; i<6; i+=3) {
//			int cnt = 0;
//			for(int j=0; i<3; j++) {
//				if(this.mark[i+j] == this.turn) {
//					cnt ++;
//				}
//			}
//			if(cnt == 3) {
//				return this.turn;
//			}
//		}
//		return 0;
//	}
//}
//
//class Frame extends JFrame{
//	
//	private  static Dimension  dm = Toolkit.getDefaultToolkit().getScreenSize();
//	public static int width = dm.width;
//	public static int height = dm.height;
//	
//	public static final int SIZE = 700;
//	
//	public Frame() {
//		setLayout(null);
//		setTitle("Tic_Tac_Toe");
//		setBounds(width/2 - SIZE/2,height/2 - SIZE/2,SIZE,SIZE);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		add(new Game());
//		
//		setVisible(true);
//		revalidate();
//	}
//}
//
//
//public class Tic_Tac_Toe {
//	public static void main(String[] args) {
//		
//		Frame frame = new Frame();
//	}
//}
