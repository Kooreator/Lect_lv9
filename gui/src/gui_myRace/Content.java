package gui_myRace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Content extends Util implements Runnable{
	Random rn = new Random();
	
	private final int SIZE = 5;
	private Horse[] horses = new Horse[SIZE];
	
	private boolean isRun;
	private int ms;
	private JLabel timer = new JLabel();
	private JButton btn = new JButton();
	
	private int sX = 30;
	private int sY = 120;
	
	public Content() {
		setLayout(null);
		setBounds(0, 0, 1000, 700);
		
		setButton();
		setHorse();
		setTimer();
		
	}

	

	private void setTimer() {
		JLabel label = new JLabel();
		label.setText("ready");
		label.setBounds(50, 60, 50, 30);
		this.timer = label;
		add(timer);
	}



	private void setButton() {
		JButton b = new JButton();
		b.setBounds(25, 20, 80, 40);
		b.setText("start");
		b.addActionListener(this);
		this.btn = b;
		add(this.btn);
	}

	private void setHorse() {
		int x = this.sX;
		int y = this.sY;
		
		for(int i=0; i<this.horses.length; i++) {
			Horse h = new Horse(i+1,x,y,120,80);
			this.horses[i] = h;
			
			y += 90;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//horses
		for(int i=0; i<5; i++) {
			Horse h = this.horses[i];
			g.drawImage(h.getImage().getImage(), h.getX(), h.getY(), null);
			g.drawLine(this.sX, h.getY() + h.getH(), 1000-30, h.getY()+h.getH());
		}
		//
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton)e.getSource();
			
			racingOn();
			this.isRun = true;
		}
	}

	private void racingOn() {

		while (true) {

			for (int i = 0; i < SIZE; i++) {
				Horse h = this.horses[i];
				
				if (h.getX() <= 970) {
					int move = rn.nextInt(50);
					h.setX(h.getX() + move);
					
				}
			}
		}
	}


	@Override
	public void run() {
		while(true) {
			if(this.isRun)
				this.ms ++;
			    this.timer.setText(String.format("%d.%d",this.ms/1000,this.ms%1000));
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				
			}
		}
	}
	
}
