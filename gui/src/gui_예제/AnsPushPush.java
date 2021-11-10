package gui_예제;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class NemoPush{
	private int x, y, width, height;
	private Color  c;
	
	public NemoPush(int x, int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

class PushPanel extends JPanel implements ActionListener,MouseListener{
	
	private final int LEFT =0;
	private final int DOWN =1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private final int SIZE = 700;
	
	private JButton [] btn =new JButton[4];
	
	private NemoPush nemo1 = null;
	private NemoPush nemo2 = null;
	
	private int dir; // 1left 2down 3right 4up
	
	private boolean isMoving ;
	
	public PushPanel() {
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);
		
		
		this.dir = 5;
		setBtn();
		setNemo();
	}
	

	private void setNemo() {
		Random rn = new Random();
		
		int rX = rn.nextInt(SIZE - 100);
		int rY = rn.nextInt(SIZE - 100);
		
		this.nemo1 = new NemoPush(rX, rY, 100, 100);
		
		while(true) {
			rX = rn.nextInt(SIZE - 100);
			rY = rn.nextInt(SIZE - 100);
			
			boolean check = false;
			///////////////////////////////
			
			if(!check) {
				this.nemo2 = new NemoPush(rX, rY, 100, 100);
				break;
			}
		}
		
		// check 
		
	}


	private void setBtn() {
		String [] text = {"←","↓","→","↑"};
		
		int x = 500;
		int y  = 550;
		for(int i=0; i<4; i++) {
			JButton bt = new JButton();
			bt.setBounds(x, y, 50, 50);
			bt.setText(text[i]);
			//bt.addActionListener(this);
			bt.addMouseListener(this);
			add(bt);
			
			this.btn[i] = bt;
			
			x += 50;
			
			if(i == this.btn.length -1 -1) {
				y -= 50;
				x -= 100;
			}
			
		}
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getWidth(), this.nemo1.getHeight());
		
//		//draw Rect
//		if(this.nemo1 != null && this.nemo2 != null) {
//			g.setColor(Color.black);
//			g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getWidth(), this.nemo1.getHeight());
//			g.setColor(Color.blue);
//			g.drawRect(this.nemo2.getX(), this.nemo2.getY(), this.nemo2.getWidth(), this.nemo2.getHeight());
//		}
		while(this.isMoving)
			    update();
		
		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.isMoving = true;
		System.out.println("click !!");
		
		//check Button
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton)e.getSource();
			
			
			if(target == this.btn[LEFT]) {
				this.dir =LEFT ;
			}else if(target == this.btn[DOWN]){
				this.dir = DOWN;
			}else if(target == this.btn[RIGHT]) {
				this.dir =RIGHT;
			}else if(target == this.btn[UP]) {
				this.dir =UP;
			}
			
			
		}
	}

	private void update() {
		if(this.dir==LEFT) {
			this.nemo1.setX(this.nemo1.getX()-1);
		}else if(this.dir ==DOWN) {
			this.nemo1.setY(this.nemo1.getY()+1);
		}else if(this.dir==RIGHT) {
			this.nemo1.setX(this.nemo1.getX()+1);
		}else if(this.dir==UP) {
			this.nemo1.setY(this.nemo1.getY()-1);
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
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
class PushPush extends JFrame{
	public PushPush() {
		setLayout(null);
		setBounds(50, 50, 700, 700);
		setTitle("Push Push");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new PushPanel());
		
		setVisible(true);
		revalidate();
	}
}

public class AnsPushPush {
	public static void main(String[] args) {
		PushPush pp = new PushPush();
	}

}
