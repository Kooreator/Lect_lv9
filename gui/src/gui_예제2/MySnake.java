package gui_예제2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javafx.scene.text.Font;

class SnakeLabel extends JLabel{
	public SnakeLabel() {
		setText("SNAKE GAME");
		setFont(new java.awt.Font("SNAKE GAME", CENTER, 25));
		setBounds(60, 50, 240, 40);
		setVisible(true);
	}
}
class SnakeNemo {
	private int x,y,w,h;
	private Color c;
	
	public SnakeNemo(int x,int y,int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = Color.black;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
}

class SnakePanel extends JPanel implements KeyListener{
	
	private JButton bt[] = new JButton[4];
	private JButton reset = new JButton("reset");
	
	private final int SIZE = 10;
	private SnakeNemo[][]map = new SnakeNemo[SIZE][SIZE];
	
	private SnakeNemo[] snake = new SnakeNemo[4]; // <-ArrayList<SnakeNemo>
	private int[][] yx = new int[4][2];            // map 인덱스 좌표 정보를 기억 
	                                                // {{y,x} ,{y,x},{y,x},{y,x}}
	private SnakeLabel text = new SnakeLabel();
	
	public SnakePanel(){
		setLayout(null);
		setBounds(0, 0, 700, 500);
		
		
		add(text);
		setButton();
		setMap();
		setUnit();
		//setItem();
		
		setFocusable(true);
		addKeyListener(this);
	}

	
	private void setUnit() {
		
	}


	private void setMap() {
		int x = 60 ;
		int y = 100 ;
		
		for(int i=0; i<this.map.length; i++) {
			for(int j=0; j<this.map[i].length; j++) {
				SnakeNemo sn = new SnakeNemo(x, y, 30, 30);
				this.map[i][j] = sn;
				x += 33;
			}
			x = 60;
			y += 33;
		}
		
		
	}


	private void setButton() {
		String[] direction = {"←","↓","→","↑"};
		
		int x = 440;
		int y = 360;
		for(int i=0; i<this.bt.length; i++) {
			
			JButton b = new JButton();
			b.setBounds(x, y, 70, 70);
			b.setText(direction[i]);
			addKeyListener(this);
			
			add(b);
			this.bt[i] = b;
			
			if(i == this.bt.length -1 -1) {
				x -= 146;
				y -= 73;
			}
			x+=73;
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
		if(e.getKeyCode() == e.VK_ENTER) {
			System.out.println("enter");
		}
		
		if(e.getKeyCode() == e.VK_LEFT) {
			System.out.println("left");
		}else if(e.getKeyCode() == e.VK_DOWN) {
			System.out.println("down");
		}else if(e.getKeyCode() == e.VK_RIGHT) {
			System.out.println("right");
		}else if(e.getKeyCode() == e.VK_UP) {
			System.out.println("up");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int x = 60 ;
		int y = 100 ;
		
		for(int i=0; i<this.map.length; i++) {
			for(int j=0; j<this.map[i].length; j++) {
				g.setColor(Color.black);
				g.drawRect(this.map[i][j].getX(), this.map[i][j].getY(),
						this.map[i][j].getW(), this.map[i][j].getH());
			}
		}
//		while() {
//			
//		}
		requestFocusInWindow();
		repaint();
	}
	
}

class SnakeFrame extends JFrame{
	
	public SnakeFrame() {
		super("Sanke");
		setLayout(null);
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new SnakePanel());
		
		setVisible(true);
		revalidate();
	}
	
}
public class MySnake {
	public static void main(String[] args) {
		SnakeFrame sf = new SnakeFrame();
	}
	
}
