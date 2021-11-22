package manager;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		setLayout(null);
		setBounds(100, 100, 700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MainPanel());
		
		setVisible(true);
		revalidate();
	}
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
