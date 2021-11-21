package gui_image;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Content extends UtillFrame implements Runnable{
	Random rn = new Random();
	
	private final int SIZE = 5;
	Horse[] horses = new Horse[SIZE];
	
	private boolean isRun;
	private int ms;
	private JLabel timer = new JLabel();
	private JButton reset = new JButton();
	
	private int sX = 30;
	private int sY = 80;
	private int endX = 1000-120-30;
	
	private int rank;
	
	public Content() {
		setLayout(null);
		setBounds(0, 0, 1000, 600);
		
		setButton();
		setTimer();
		setHorse();
	}
	
	private void setButton() {
		this.reset.setBounds(25, 20, 80, 40);
		this.reset.setText("start");
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setHorse() {
		this.rank = 1;
		int x = this.sX;
		int y = this.sY;
		
		for(int i=0; i<SIZE; i++) {
			this.horses[i] = new Horse(i+1, x, y, 120,80 );
			y += 90;
		}
		
	}

	private void setTimer() {
		this.timer.setBounds(50, 50, 50, 30);
		this.timer.setText("ready");
		add(this.timer);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//horses
		for(int i=0; i<SIZE; i++) {
			Horse h = this.horses[i];
			g.drawImage(h.getImage().getImage(), h.getX(),h.getY(), null);
			g.drawLine(this.sX, h.getY()+h.getH(), 1000-30, h.getY()+h.getH());
			
			if(h.getState() == h.GOAL) {
				g.setFont(new Font("",Font.BOLD,20));
				g.drawString(h.getRank()+"등", this.endX-50, h.getY()+h.getH()/2);
				g.setFont(new Font("",Font.PLAIN,10));
				g.drawString(h.getRecord(), this.endX-50, h.getY()+h.getH()/2+18);
			}
			
		}
		if(isRun) {
			try {
				Thread.sleep(50);
				update();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		repaint();
	}
	 
	private void update() {
		//5마리의 말들이 랜덤 이동
		//setX()
		
		//1번 update 할 떼에 1마리만 골인 할 수 있다.
		boolean goal = false;
		
		for(int i=0; i<SIZE; i++) {
			Horse h = this.horses[i];
			int jump = rn.nextInt(10)*5;
			
			int xx = h.getX() + jump;
			
			if(h.getState() == h.RUN) {
				if(xx >= this.endX && !goal) {
					xx = this.endX;
					h.setState(h.GOAL);
					h.setRecord(String.format("%d.%03d", this.ms/1000,this.ms%1000));
					h.setRank(this.rank);
					this.rank++;
					goal = !goal;
				}
				else if(xx >= this.endX && goal) {
					i --;
					continue;
				}
				h.setX(xx);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() == this.reset) {
			this.isRun = !this.isRun;
			this.reset .setText(this.isRun ? "reset" : "start");
			if(!this.isRun) {
				resetGame();
			}
		}
	}
	
	private void resetGame() {
		setHorse();
		this.ms = 0;
		this.timer.setText("ready");
		this.rank = 1;
	}

	@Override
	public void run() {
		while(true) {
			if(this.isRun) {
				this.ms ++;
				this.timer.setText(String.format("%3d.%03d", this.ms));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
