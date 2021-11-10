package gui_예제;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class PushGamePanel extends JPanel implements ActionListener,MouseListener{
	
	private final int SIZE = 700;
	private JLabel jl = new JLabel();
	private JButton jb = new JButton();
	
	public PushGamePanel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		setJb();
	}

	private void setJb() {
		int x = 700/3;
		int y = 700/3;
		
		this.jb.setBounds(x, y, SIZE/3, SIZE/3);
		this.jb.setText("깡순이는 무슨 말을 했을까");
		this.jb.setForeground(Color.black);
		this.jb.addMouseListener(this);
		this.jb.addActionListener(this);
		add(jb);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.jl.setBackground(Color.GRAY);
	    this.jl.setBounds(30, 30, 80, 80);
		this.jl.setText("백슉믁쟈 해짜나아!!!");
		this.jl.setVisible(true);
		this.jl.setForeground(Color.green);
		add(this.jl);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.jb.setForeground(Color.BLUE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.jb.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.jb.setForeground(Color.black);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jl.setBackground(Color.GRAY);
		this.jl.setBounds(30, 30, 200, 80);
		this.jl.setText("백슉믁쟈 해짜나아!!!");
		this.jl.setVisible(true);
		this.jb.setForeground(Color.green);
		
	}
}
class PushGameFrame extends JFrame{
	public PushGameFrame() {
		setLayout(null);
		setTitle("PUSHGAME");
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PushGamePanel());
		setVisible(true);
		revalidate();
		
	}
}
public class EExx {
	public static void main(String[] args) {
		PushGameFrame  pgf = new PushGameFrame();
	}

}
