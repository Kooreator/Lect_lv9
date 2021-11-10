package gui_예제;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Panel extends JPanel implements MouseListener{
	
	private final int SIZE = 10;
	private Rect[][] map = new Rect[SIZE][SIZE];
	
	private int turn = 1;
	private int win =  0;
	

	
	public Panel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		setMap();
		addMouseListener(this);
		
		
	}
	private void setMap() {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
class Frame extends JFrame{
	public Frame() {
		setLayout(null);
		setTitle("OMOK2");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Panel());
		
		setVisible(true);
		revalidate();
	}
}
public class OmokTwo {
	public static void main(String[] args) {
		Frame frame = new Frame();
	}

}
