//package gui_예제;
//
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Graphics;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.Random;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.Border;
//
//
//class PushGameNemo {
//	private int x,y,w,h;
//	private Color c;
//	
//	public PushGameNemo(int x , int y ,int w ,int h) {
//		this.x = x;
//		this.y = y;
//		this.w = w;
//		this.h = h;
//		this.c = Color.black;
//	}
//	
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	public int getW() {
//		return w;
//	}
//	public void setW(int w) {
//		this.w = w;
//	}
//	public int getH() {
//		return h;
//	}
//	public void setH(int h) {
//		this.h = h;
//	}
//	public Color getC() {
//		return c;
//	}
//	public void setC(Color c) {
//		this.c = c;
//	}
//}
//class PushPanel extends JPanel implements MouseListener , ActionListener{
//	
//	private final int LEFT = 0;
//	private final int DOWN = 1;
//	private final int RIGHT = 2;
//	private final int UP = 3;
//	
//	private final int SIZE = 700;
//	
//	private JButton[] button = new JButton[4];
//	
//	private PushGameNemo  nemo1 = null;
//	private PushGameNemo nemo2 = null;
//	
//	private int dir; 
//	private boolean isMoving;
//	
//	
//	public PushPanel() {
//		setLayout(null);
//		setBounds(0, 0, 700, 700);
//		
//		this.dir = 100;
//		
//		setNemo();
//		setButton();
//	
//	}
//
//	private void setNemo() {
//		Random rn = new Random();
//		
//		int rX = rn.nextInt(SIZE - 100);
//		int rY = rn.nextInt(SIZE - 100);
//		
//		this.nemo1 = new PushGameNemo(rX, rY, 100, 100);
//		
//		while(true) {
//			rX = rn.nextInt(SIZE - 100);
//			rY = rn.nextInt(SIZE - 100);
//			
//			boolean check = false;
//			
//			if(!check) {
//				this.nemo2 = new PushGameNemo(rX,rY,100,100);
//				break;
//			}
//			
//		}
//		
//	}
//
//	private void setButton() {
//		String[] keys = {"←","↓","→","↑"};
//		int x = 500;
//		int y = 550;
//		
//		for(int i=0; i<4; i++) {
//			JButton bt = new JButton();
//			bt.setBounds(x, y, 50, 50);
//			bt.setText(keys[i]);
//			addMouseListener(this);
//			add(bt);
//			
//			this.button[i] = bt;
//			
//			x += 50;
//			
//			if(i == this.button.length -1 -1) {
//				y -=50;
//				x -=100;
//			}
//		}
//	}
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		g.setColor(Color.black);
//		g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
////		g.setColor(Color.blue);
////		g.drawRect(this.nemo2.getX(), this.nemo2.getY(), this.nemo2.getW(), this.nemo2.getH());
////		
//		while(this.isMoving)
//			update();
//		
//		
//		
//		repaint();
//	}
//
//	private void update() {
//		if(this.dir == LEFT) {
//			this.nemo1.setX(this.nemo1.getX()-1);
//		}else if(this.dir == DOWN) {
//			this.nemo1.setY(this.nemo1.getW()+1);
//		}else if(this.dir == RIGHT) {
//			this.nemo1.setX(this.nemo1.getX()+1);
//		}else if(this.dir == UP) {
//			this.nemo1.setY(this.nemo1.getW()-1);
//		}
//		
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		this.isMoving = true;
//		System.out.println("click !!");
//		
//		if(e.getSource() instanceof JButton) {
//			JButton target = (JButton)e.getSource();
//			
//			if(target == this.button[LEFT]) {
//				this.dir = LEFT;			
//			}else if(target == this.button[DOWN]) {
//				this.dir = DOWN;
//			}else if(target == this.button[RIGHT]) {
//				this.dir = RIGHT;			
//			}else if(target == this.button[UP]) {
//				this.dir = UP;			
//			}
//		}
//	}
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		this.isMoving = false;
//	}
//	
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		
//	}
//	
//	@Override
//	public void mouseExited(MouseEvent e) {
//		
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		
//	}
//
//}
//
//class PushFrame extends JFrame{
//	public PushFrame() {
//		setLayout(null);
//		setTitle("Push ");
//		setBounds(50, 50, 700, 700);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		add(new PushPanel());
//		
//		setVisible(true);
//		revalidate();
//	}
//}
//
//public class MyPushPush {
//	public static void main(String[] args) {
//		PushFrame pf = new PushFrame();
//	}
//
//}
