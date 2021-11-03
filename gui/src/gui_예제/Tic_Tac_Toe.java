package gui_예제;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




class ResultGame extends JPanel{
	public ResultGame() {
		
	}
}


class Game extends JPanel implements ActionListener {
	
	public Game() {
		setLayout(null);
		setBounds(0, 0,Frame.SIZE, );
		
//		setTitle();
//		setMap();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

class Frame extends JFrame{
	
	public static Dimension  dm = Toolkit.getDefaultToolkit().getScreenSize();
	private static int width = dm.width;
	private static int height = dm.height;
	
	private static final int SIZE = 700;
	
	public Frame() {
		setLayout(null);
		setTitle("Tic_Tac_Toe");
		setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//add();
		
		setVisible(true);
		revalidate();
	}
}


public class Tic_Tac_Toe {
	public static void main(String[] args) {
		
		Frame frame = new Frame();
	}
}
