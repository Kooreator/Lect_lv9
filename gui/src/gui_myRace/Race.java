package gui_myRace;

import javax.swing.JFrame;

public class Race extends JFrame{
	
	Content content = new Content();
	
	public Race() {
		setLayout(null);
		setBounds(100, 100, 1000, 700);
		setTitle("Race Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(content);
		
		setVisible(true);
		revalidate();
		
		content.run();
	}
	public static void main(String[] args) {
		Race race = new Race();
	}
}
