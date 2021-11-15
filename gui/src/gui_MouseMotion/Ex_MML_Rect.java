package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class RectNemo {
	private int x,y,w,h;
	private Color c;
	
	public RectNemo(int x, int y, int w, int h ,Color c){
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
class RectPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener {
	
	private int sX,sY; 
	private RectNemo rect = null;
	private boolean shift;
	private ArrayList<RectNemo> rectList = new ArrayList<RectNemo>();
	
	public RectPanel(){
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
		
		RectNemo r = this.rect;
		
		if(r != null) {			
			g.setColor(r.getC());
			g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
		}
		
		requestFocusInWindow();
		repaint();
		
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
		
		if(x < this.sX)
			rX = this.sX - w;
		if(y < this.sY)
			rY = this.sY - h;
		
		this.rect = new RectNemo(rX,rY,w,h,Color.red);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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
}
class RectFrame extends JFrame {
	public RectFrame() {
		setLayout(null);
		setTitle("Creat Rect");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new RectPanel());
		
		setVisible(true);
		revalidate();
		
	}
}
public class Ex_MML_Rect {
	public static void main(String[] args) {
		RectFrame rf = new RectFrame();
	}

}
