package gui_소코반;

import javax.swing.JFrame;

public class Sokoban extends JFrame{
	
	public Sokoban() {
		setLayout(null);
		setBounds(100, 100, 800, 900);
		setTitle("sokoban");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Play());
		
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		Sokoban game = new Sokoban();
		
		
	}
}
