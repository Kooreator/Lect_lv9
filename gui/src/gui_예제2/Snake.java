package gui_예제2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnakeRect{
	private int x,y,w,h;
	private Color c;
	
	public SnakeRect(int x, int y, int w,int h,Color c) {
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

class SnakeGame extends JPanel implements KeyListener{
	
	private final int SIZE = 10;
	private SnakeRect[][] map = new SnakeRect[SIZE][SIZE];
	
	private SnakeRect[] snake = new SnakeRect[4];
	private int [][] yx = new int [4][2];        // map 인덱스 좌표 정보를 기억 
                                                 // {{y,x} ,{y,x},{y,x},{y,x}}
	
	public SnakeGame() {
		setLayout(null);
		setBounds(0, 0, 700, 500);
		
		setFocusable(true);
		addKeyListener(this);
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
			
		}
		else if(e.getKeyCode() == e.VK_DOWN) {
			
		}
		else if(e.getKeyCode() == e.VK_RIGHT) {
			
		}
		else if(e.getKeyCode() == e.VK_UP) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		requestFocusInWindow(); // <- 키 리스너를 위한 포커스를 재요청
		repaint();
	}
}

public class Snake extends JFrame{
	
	public Snake() {
		super("snake");
		setBounds(100,100,700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new SnakeGame());
		
		setVisible(true);
		revalidate();
	}
	
	public static void main(String[] args) {
		Snake game = new Snake();
	}

}
