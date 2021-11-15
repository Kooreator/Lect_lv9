package gui_MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MMLNemo2 {
	private int x,y,w,h;
	private Color c;
	
	public MMLNemo2(int x, int y, int w, int h, Color c) {
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
class MMLPanel2 extends JPanel implements MouseMotionListener,MouseListener{
	
	private boolean isMoving;
	private MMLNemo2 nemo = null ;
	private int gapW, gapH;
	
	public MMLPanel2() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		setBackground(Color.orange);
		
		setNemo();
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(this.nemo.getC());
		g.fillRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getW(), this.nemo.getH());
		
		repaint();
	}

	private void setNemo() {
		Random rn = new Random();
		int x = rn.nextInt(700-100);
		int y = rn.nextInt(700-100);
		
		this.nemo = new MMLNemo2(x,y,100,100,Color.blue);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX(); int y = e.getY();
		
		if (x >= this.nemo.getX() && x < this.nemo.getX() + this.nemo.getW() && y >= this.nemo.getY()
				&& y < this.nemo.getY() + this.nemo.getH()) {
			this.isMoving = true;
			this.gapW = x - this.nemo.getX();
			this.gapH = y - this.nemo.getY();
		}
			
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMoving = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("hello");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("bye-");
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX(); int y = e.getY();
		
		if(isMoving) {
			this.nemo.setX(x -gapW);
			this.nemo.setY(y -gapH);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.printf("Move\nx : %d , y : %d\n",x,y);
	}
}

class MMLFrame2 extends JFrame{
	public MMLFrame2() {
		setLayout(null);
		setTitle("MML");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MMLPanel2());
		
		setVisible(true);
		revalidate();
	}
}
public class AnsMML {
	public static void main(String[] args) {
		MMLFrame2  mm =new MMLFrame2();
	}

}
