package gui_예제;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ButtonjPanel extends JPanel{
	 
	public JButton reset = new JButton();
	
	public ButtonjPanel() {
		setLayout(null);
		setBounds(0, 0, OmokFrame.SIZE, OmokFrame.SIZE);
		
		setResetButton();
	}
	
	private void setResetButton() {
		this.reset.setText("Reset");
		this.reset.setFont(new Font("",Font.PLAIN,50));
		this.reset.setBounds(OmokFrame.SIZE/2-150, OmokFrame.SIZE/2-150, 300, 300);
		add(this.reset);
		
	}
}

class Result extends JFrame{
	
	private JLabel text = new JLabel();
	
	public Result(String str) {
		super("Game Over");
		setBounds(OmokFrame.W/2-150, OmokFrame.H/2-100, 300, 200);
		
		text.setText(str);
		text.setBounds(0, 0, 300, 200);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}

class  OmokPanel extends JPanel implements ActionListener{
	
	private JLabel text = new JLabel("Omok Game");
	
	private final int SIZE = 10;
	private JButton[][] map = new JButton[SIZE][SIZE];
	private int [][] mark = new int[SIZE][SIZE];
	
	private int turn = 1;
	private int win ;
	
	private ButtonjPanel reset = new ButtonjPanel();
	
    public OmokPanel() {
		setLayout(null);
		setBounds(0,0 ,OmokFrame.SIZE , OmokFrame.SIZE);
		//setBackground(Color.white);
		
		//add(추가할 컴포넌트 , 0)
		//0 ... 우선순위 설정
		
		//add하는 순서대로 컴포넌트의 우선순위가 top 부터 정해짐.
		this.reset.reset.addActionListener(this);
		add(this.reset);
		this.reset.setVisible(false);
		
		setTitle();
		
		setMap();
		
		
		
	}

	

	private void setTitle() {
		this.text.setBounds(0, 0, OmokFrame.SIZE, 100);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setFont(new Font("",Font.BOLD,30));
		add(this.text);
		
	}

	private void setMap() {
		
		int x = OmokFrame.SIZE/2-50*10/2;
		int y = OmokFrame.SIZE/2-50*10/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				//버튼생성
				JButton bt = new JButton();
				
				//버튼 설정
				bt.setBounds(x, y, 50, 50);
				
				//색설정
				bt.setBackground(Color.lightGray);
				bt.setOpaque(true);
				bt.setBorderPainted(false);
				
				//이벤트 리스너 달기
				//JButton : ActionListener <- 이터페이스로 제공
				bt.addActionListener(this); // this : 버튼 <- 이벤트 발생 시 ,actionPerformed() 메소드가 동작
				
				this.map[i][j] = bt;
				
				// 현재 패널 (this)버튼 달기
				add(this.map[i][j]);// add();
				
				//다음 버튼을 위한 좌표 설정
				x += 50 + 1;
				
			
			}
			x= OmokFrame.SIZE/2-50*10/2;
			y += 50 + 1;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton)e.getSource();
			
			if(target == this.reset.reset ) {
				resetGame();
				System.out.println("reset");
			}else {
				
				//맴 안에 있는 버튼이 맞는지,
				//어떤 버튼인지
				//turn 에 따라서 -> marking
				for(int i=0; i<this.map.length; i++) {
					for(int j=0; j<this.map[i].length; j++) {
						if(target == this.map[i][j] && this.mark[i][j] == 0) {//아직 마킹되지 않은 자리 확인
							if(this.turn == 1) {
								target.setBackground(Color.red);
								
							}else {
								target.setBackground(Color.blue);
							}
							
							this.mark[i][j] = this.turn;
							
							winCheck();
							
							
							this.turn = this.turn == 1 ? 2 : 1;
						}
					}
				}
			}
			
		}
		
	}

	private void resetGame() {
		this.mark = new int [SIZE][SIZE];
		this.turn = 1;
		this.win = 0;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0;j<SIZE;j++) {
				this.map[i][j].setBackground(Color.lightGray);
			}
		}
		
//		//컴포넌트 삭제
//		this.remove(this.reset);
//		this.revalidate();
//		this.repaint();
		
		this.reset.setVisible(false);
		
	}
	private void winCheck() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			this.reset.setVisible(true); //게임이 클리어 되면 -> 리셋버튼의 등장
			new Result(String.format("p%d win!",this.win));
		}
	}

	private int checkReverse() {
		for(int i=4; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i-k][j+k]==this.turn)
							cnt ++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkDia() {
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j+k]==this.turn)
							cnt ++;
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkVerti() {
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j]==this.turn)
							cnt ++;
					}
					if(cnt == 5) 
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkHori() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i][j+k] == this.turn) {
							cnt ++;
						}
					}
					if(cnt == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}
	
}

class OmokFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int SIZE = 700;

	private OmokPanel panel = new OmokPanel();
	
	public OmokFrame() {
		
		setLayout(null);
		setTitle("OMOK");
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
	}
	
}
public class TEx_오목 {
	public static void main(String[] args) {
		OmokFrame of =new OmokFrame();
	}

}
