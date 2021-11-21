package gui_소코반;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;








class ExPanel extends JPanel implements KeyListener{
	
	//줄바꿈 불가능
	JTextField jf = new JTextField();
	
	// 줄바꿈 가능 -> JTextArea
	JTextArea jA = new JTextArea();
	
	
	
	
	public ExPanel() {
		setLayout(null);
		setBounds(0,0,400,500);
		
		setTextField();
		
		setTextArea();
	}

	private void setTextArea() {
		this.jA.setBounds(100, 180, 200, 200);
		add(this.jA);
		
	}

	private void setTextField() {
		this.jf.setBounds(100, 100, 100, 30);
		this.jf.setFocusable(true);
		this.jf.addKeyListener(this);
		add(this.jf);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_ENTER) {
			System.out.println(this.jf.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}

public class Ex extends JFrame{
	
	public Ex() {
		setLayout(null);
		setBounds(100,100,400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new ExPanel());

		setVisible(true);
		revalidate();
	}
	
	public static void main(String[] args) {
		new Ex();
	}

}
