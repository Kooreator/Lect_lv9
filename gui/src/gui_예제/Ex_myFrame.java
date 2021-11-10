package gui_예제;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Nemo{
	private int x, y, width, height;
	private Color  c;
	
	public Nemo(int x, int y,int width,int height,Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
}

class MyPanel extends JPanel implements MouseListener{
	
	//private Nemo nemo = new Nemo();
	
	private Nemo[][] map = new Nemo[3][3];
	
	public MyPanel() {
		setLayout(null);
		setBounds(0,0, 500, 400);
		setBackground(Color.orange);
		
//		nemo.setX(100);
//		nemo.setY(100);
//		nemo.setWidth(200);
//		nemo.setHeight(200);
//		nemo.setC(Color.blue);
//		
		setMap();
		
		//패널에 혹은 특정하는 컴포넌트에 -> 마우스 리스너 달 수 O
		
		addMouseListener(this); // this : MyPanel
		
	
	}
	
	private void setMap() {
		
		int x = 50;
		int y = 50;
		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.map[i][j] = new Nemo(x, y, 50, 50, Color.red);
				x+=50;
			}
			x=50;
			y+= 50;
		}
		
	}

		
		
	
	//printcomponent() 메소드 오버라이딩(JComponent)
	
	@Override
	protected void printComponent(Graphics g) { // 스레드
		super.printComponent(g); // 그래픽을 지움

//		g.setColor(Color.red);
//		g.drawRect(100, 100, 100, 100);
//		g.fillRect(100, 100, 100, 100);
//		
//		g.setColor(this.nemo.getC());
//		g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());

		// draw Map
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Nemo temp = this.map[i][j];
				g.setColor(temp.getC());
				// g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
				g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(), temp.getHeight());
			}

		}
		// 다시 그리기
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("클 - ");
		 
		int x = e.getX();
		int y = e.getY();
		
		System.out.println(x+"/"+y);
		
//		if(x > this.nemo.getX() && x < this.nemo.getX() + this.nemo.getWidth() 
//		   && y >= this.nemo.getY()&& y<this.nemo.getY()+this.nemo.getHeight()) {
//			this.nemo.setC(Color.red);
//		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("릭!");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("hello");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("bye - ");
		
	}
}

class MyFrame extends JFrame{
	public MyFrame() {
		setLayout(null);
		setTitle("MyFrame");
		setBounds(50,50,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MyPanel());
		
		setVisible(true);
		revalidate();
	}
}

public class Ex_myFrame {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame(); 
	}

}
