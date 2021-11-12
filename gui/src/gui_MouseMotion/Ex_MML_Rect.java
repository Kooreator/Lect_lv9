package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
class RectPanel extends JPanel implements MouseListener,MouseMotionListener {
	
	private int sX,sY;  private int fX,fY;
	private RectNemo rect = null;
	private int x,y,w,h;
	
	
	public RectPanel(){
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		
		setNemo();
		
		setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void setNemo() {
		RectNemo rect = new RectNemo(this.x, this.y, this.w, this.h,Color.red);
		this.rect = rect;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		RectNemo r = this.rect;
		
		g.setColor(r.getC());
		g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
		
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.fX = e.getX();
		this.fY = e.getY();
		while(true) {
			if(this.sX >= this.fX ) {
				if(this.sY > this.fY) {
					this.x = this.fX;
					this.y = this.fY;
					this.w = this.sX - this.fX;
					this.h = this.sY - this.fY;
				}else if(this.sY < this.fY) {
					this.x = this.fX;
					this.y = this.fY;
					this.w = this.sX - this.fX;
					this.h = this.fY - this.sY;
				}
			}else if(this.sX <= this.fX) {
                if(this.sY < this.fY) {
                	this.x = this.sX;
                	this.y = this.sY;
                	this.w = this.fX - this.sX;
                	this.h = this.fY - this.sY;
				}else if(this.sY > this.fY) {
					this.x = this.sX;
					this.y = this.fY;
					this.w = this.fX - this.sX;
					this.h = this.sY - this.fY;
				}
			}
			//setNemo();
		}
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
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
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
