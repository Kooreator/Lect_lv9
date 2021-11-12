package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class RectNemo2 {
	private int x,y,w,h;
	private Color c;
	public RectNemo2(int x, int y, int w, int h,Color c ){
		this.x = x;
		this.y = y;
		this.w = w;
		this.y = y;
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
class RectPanel2 extends MyUtill {
	
	private RectNemo2 rect = null;
	private int sX, sY;
	private boolean shift;
	
	public RectPanel2(){
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		addKeyListener(this);
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.rect != null) {
			g.setColor(this.rect.getC());
			g.drawRect(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH());
		}
		
		requestFocusInWindow();
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = false;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.sX = e.getX();
		this.sY = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.rect.setC(Color.blue);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		int w = Math.abs(x - this.sX);
		int h = Math.abs(y - this.sY);
		
		if(this.shift)
			w = h;
		
		int rX = this.sX; 
		int rY = this.sY;
		
		if(x < this.sX ) 
			rX = this.sX - w;
		if(y < this.sY)
			rY = this.sY - h;
		
		this.rect = new RectNemo2(rX,rY,w,h,Color.red);
		
	}
	
}
class RectFrame2 extends JFrame {
	public RectFrame2() {
		setLayout(null);
		setTitle("C R");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new RectPanel2());
		
		setVisible(true);
		revalidate();
		
	}
}
public class As_MML_Rect {
	public static void main(String[] args) {
		RectFrame2 rf2 = new RectFrame2(); 
	}

}
