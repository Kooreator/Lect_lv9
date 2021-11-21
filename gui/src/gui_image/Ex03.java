package gui_image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImagePanel extends JPanel{
	
	ImageIcon icon = null;
	
	public ImagePanel(ImageIcon icon) {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		
		this.icon = icon;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//drawImage(Image,x,y,null);
		g.drawImage(this.icon.getImage(), 0, 0, null);
		
		repaint();
	}
}

public class Ex03 extends JFrame{
	
	JLabel image = null;
	Image im = new ImageIcon("images/스폰지밥이미지.png").getImage().getScaledInstance(400, 500,Image.SCALE_SMOOTH);
	ImageIcon icon = new ImageIcon(im);
	
	public Ex03() {
		super("image");
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//setImageLabel();
		add(new ImagePanel(icon));
		
		setVisible(true);
		revalidate();
		
	}
	
	
	private void setImageLabel() {
		//ImageIcon
		
		this.image = new JLabel(icon);
		this.image.setBounds(0, 0, 400, 500);
		add(this.image);
		
	}


	public static void main(String[] args) {
		new Ex03();
	}

}
