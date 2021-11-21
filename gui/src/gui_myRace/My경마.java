package gui_myRace;

//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.java.swing.plaf.gtk.resources.gtk;

//import gui_image.UtillFrame;

class Timer extends Thread{
	
}

class HorsePanel extends Util{
	
	JLabel timer = new JLabel();
	JButton start = new JButton();
	boolean run ;
	ImageIcon icon = null;
	
	public HorsePanel(ImageIcon icon) {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		setTimer();
		setButton();
		
		this.icon = icon;
	}
	
	
	private void setTimer() {
		
		
	}


	private void setButton() {
		int x = 30; int y = 60;
		JButton b = this.start;
		b.setBounds(x, y, 80, 30);
		b.setText("start");
		b.addActionListener(this);
		add(b);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//drawImage(Image,x,y,null);
		g.drawImage(this.icon.getImage(), 0, 0, null);
		
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton)e.getSource();
			
			if(!this.run) {
				b.setText("reset");
				
				this.run = true;
			}else if(this.run) {
				b.setText("start");
				
				this.run = false;
			}
		}
		
	}
}

class HorseFrame extends JFrame{
	
	JLabel image = null;
	Image[] images = new Image[5];
	ImageIcon icon;
	
	public HorseFrame() {
		setLayout(null);
		setBounds(100, 100, 700, 700);
		setTitle("horse game");
		
		
		setImages();
		
		setVisible(true);
		revalidate();
	}
	
	
	private void setImages() {
//		int x 
		String[] potos = { "horse1", "horse2", "horse3", "horse4", "horse5" };

		for (int i = 0; i < images.length; i++) {
			this.images[i] = new ImageIcon("images_race" + potos[i] + ".png").getImage().
					getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			icon = new ImageIcon(images[i]);
			add(new HorsePanel(icon));
		}
	}
}

public class My경마 {
	public static void main(String[] args) {
		HorseFrame hf = new HorseFrame();
	}

}
