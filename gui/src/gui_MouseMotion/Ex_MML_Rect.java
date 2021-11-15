package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
class RectPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener,ActionListener {
	
	private int sX,sY; 
	private RectNemo rect = null;
	private boolean shift;
	private ArrayList<RectNemo> rects = new ArrayList<RectNemo>();
	private ArrayList<RectNemo> circles = new ArrayList<RectNemo>();
	
	String[] btnText = {"ㅁ","ㅇ","ㅅ"};
	JButton[] btn = new JButton[3];
	private int type ;
	
	private final int RECTANGLE = 0;
	private final int CIRCLE = 1;
	private final int TRIANGLE = 2;
	
	public RectPanel(){
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		setButton();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		addKeyListener(this);
	}

	private void setButton() {
		int x = 30;
		int y = 50;
		
		for(int i= 0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].setText(this.btnText[i]);
			this.btn[i].addActionListener(this);
			add(this.btn[i]); 
			
			y += 50+3;
		}
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//sample triangle
		//g.drawPolygon(int [],int [],int)
		// 1.x 좌표의 배열  2.y좌표의 배열 3.꼭지점 개수
		int[] xx = new int[3];
		int[] yy = new int[3];
		xx[0] = 100;
		yy[0] = 100;
		xx[1] = 150;
		yy[1] = 200;
		xx[2] = 50;
		yy[2] = 200;
		g.setColor(Color.green);
		g.drawPolygon(xx,yy,3);
		
		
		RectNemo r = this.rect;
		
		if(r != null) {			
			g.setColor(r.getC());
			
			if(this.type == RECTANGLE) {
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
			}else if(this.type == CIRCLE) {
				g.drawRoundRect(r.getX(), r.getY(), r.getW(), r.getH(),r.getW(),r.getH());
			}else if(this.type == TRIANGLE) {
				
			}
			
		}
		//rects
		for(int i=0; i<this.rects.size(); i++) {
			RectNemo n = this.rects.get(i);
			g.setColor(n.getC());
			g.drawRect(n.getX(),n.getY(),n.getW(),n.getH());
		}
		//circles
		for(int i=0; i<this.circles.size(); i++) {
			RectNemo n = this.circles.get(i);
			g.setColor(n.getC());
			g.drawRoundRect(n.getX(), n.getY(), n.getW(), n.getH(), n.getW(), n.getH());
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
		
		if(this.type == RECTANGLE) {
			this.rects.add(this.rect);
			
		}else if(this.type == CIRCLE) {
			this.circles.add(this.rect);
			
		}else if(this.type == TRIANGLE) {
			
		}
		this.rect = null;
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn[RECTANGLE]) {
			this.type = RECTANGLE;
		}
		else if(e.getSource() == this.btn[CIRCLE]) {
			this.type = CIRCLE;
		}
		else if(e.getSource() == this.btn[TRIANGLE]) {
			this.type = TRIANGLE;
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
