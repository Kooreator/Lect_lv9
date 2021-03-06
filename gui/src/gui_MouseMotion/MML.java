package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MMLNemo {
	private int x,y,w,h;
	private Color c;
	
	public MMLNemo(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setW(int w) {
		this.w = w;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
}
class MMLPanel extends JPanel implements MouseMotionListener,MouseListener{
	
	private MMLNemo nemo = null;
	private boolean isMoving;
	private int gapW, gapH;
	
	public MMLPanel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		setNemo();
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		MMLNemo n = this.nemo;
		g.setColor(n.getC());
		g.drawRect(n.getX(),n.getY(),n.getW(),n.getH());
		
		repaint();
	}

	private void setNemo() {
		Random rn = new Random();
		int x = rn.nextInt(700-110);
		int y = rn.nextInt(700-110);
		
		this.nemo = new MMLNemo(x,y,100,100,Color.blue);
		
	}
	//1. 클릭되는 순간 마우스의 좌표를 기억 (패널 안에서 의 좌표)
	//2. 1번을 수행하면서 nemo와 클릭된 자표를 비교해 기억
	//3. 1,2번을 토대로 nemo를 repaint??
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		MMLNemo n = this.nemo;
		int x = e.getX(); int y = e.getY();
		
		if( x >= n.getX() && x < n.getX() + n.getW() 
		   && y >= n.getY() && y < n.getY() + n.getH()) {
			this.isMoving = true;
			this.gapW = x - n.getX();
			this.gapH = y - n.getY();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMoving = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(this.isMoving) {
			this.nemo.setX(x - gapW);
			this.nemo.setY(y - gapH);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.printf("Move\nx : %d , y : %d\n",x,y);
	}
}

class MMLFrame extends JFrame{
	public MMLFrame() {
		setLayout(null);
		setTitle("MML");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MMLPanel());
		
		setVisible(true);
		revalidate();
	}
}
public class MML {
	public static void main(String[] args) {
		MMLFrame mml = new MMLFrame();
	}

}
