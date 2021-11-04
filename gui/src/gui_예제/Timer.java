package gui_예제;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Clock extends JFrame implements Runnable{
	
	private JLabel timer = new JLabel();
	
	public Clock() {
		super("clock");
		setLayout(null);
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTimer();
		
		setVisible(true);
		revalidate();
	}
	private void setTimer() {
		this.timer.setBounds(0, 0, 400, 400);
		this.timer.setText("ready");
		this.timer.setFont(new Font("",Font.BOLD,50));
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
	}
	
	public void setTimer(int time) {
		this.timer.setText(String.format("%5d,%3d",time/1000,time%1000));
	}
	@Override
	public void run() {
		int n= 0; 
		while(true) {
			n++;
			this.timer.setText(String.format("%5d,%3d",n/1000,n%1000));
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// TODO Auto-generated method stub
	}
}

public class Timer {
	public static void main(String[] args) {
		
		Clock clock = new Clock();
		
		int n= 0; 
		while(true) {
			n++;
			clock.setTimer(n);
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
