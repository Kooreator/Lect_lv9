package gui_Login_Inrollment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



class ErrorMessage extends JFrame{
	
	private JLabel label = new JLabel("중복 아이디는 \n사용할 수 없습니다.");
	
	public ErrorMessage() {
		setLayout(null);
		setBounds(150,150,250,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		label.setBounds(20, 40, 180, 80);
		
		add(this.label);
		
		setVisible(true);
		revalidate();
	}
}

class MainPanel extends JPanel implements ActionListener ,KeyListener{
	
	public static MainPanel main = new MainPanel();
	
	private JButton login = new JButton();
	private JButton inrollment = new JButton();
	
	private Vector<Vector<String>> usersInfo = new Vector<>();
	
	private Inrollment inrollFrame;
	
	private Login loginFrame;
	
	private int log = -1;
	
	
	
	
	public MainPanel() {
		setLayout(null);
		setBounds(0, 0, 700, 600);
		
		setButton();
		
	}
	
	public Vector<Vector<String>> getUsersInfo (){
		return this.usersInfo;
	}

	private void setButton() {
		this.login.setBounds(100, 100, 100, 100);
		this.login.setText("Login");
		this.login.setVisible(true);
		this.login.addActionListener(this);
		add(this.login);
		
		this.inrollment.setBounds(210,100,100,100);
		this.inrollment.setText("Inrollment");
		this.inrollment.setVisible(true);
		this.inrollment.addActionListener(this);
		add(this.inrollment);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.login) {
			this.loginFrame = new Login();
			
			this.loginFrame.idField.setFocusable(true);
			this.loginFrame.idField.addKeyListener(this);
			this.loginFrame.pwField.setFocusable(true);
			this.loginFrame.pwField.addKeyListener(this);
			
		}else if(e.getSource() == this.inrollment) {
			this.inrollFrame = new Inrollment();
			
			this.inrollFrame.idField.setFocusable(true);
			this.inrollFrame.idField.addKeyListener(this);
			this.inrollFrame.pwField.setFocusable(true);
			this.inrollFrame.pwField.addKeyListener(this);
			this.inrollFrame.nameField.setFocusable(true);
			this.inrollFrame.nameField.addKeyListener(this);
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		Object target = e.getKeyCode();
		int num = -1;
		if (this.loginFrame != null) {
			if (e.getKeyCode() == e.VK_ENTER || target == this.loginFrame.idField
					|| target == this.loginFrame.pwField) {
				String id = this.loginFrame.idField.getText();
				String pw = this.loginFrame.pwField.getText();
				if (check(id, pw)) {
					JOptionPane.showMessageDialog(null, "로그인 완료");
					this.loginFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 불가");
					this.loginFrame.dispose();
				}
				num = 1;
			} else {

			}
		}
		if (this.inrollFrame != null && num == -1) {
			if (e.getKeyCode() == e.VK_ENTER || target == this.inrollFrame.idField || target == this.inrollFrame.pwField
					|| target == this.inrollFrame.nameField) {
				if (checkDuplication()) {
					Vector<String> user = new Vector<>();
					user.add(this.inrollFrame.idField.getText());
					user.add(this.inrollFrame.pwField.getText());
					user.add(this.inrollFrame.nameField.getText());
					this.usersInfo.add(user);
					System.out.println("가입완료!!");
					this.inrollFrame.dispose();
					for (int i = 0; i < user.size(); i++) {
						System.out.println(user.get(i));
					}
				} else {
					new ErrorMessage();
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public boolean check(String id , String pw) {
		
		if (this.usersInfo.size() > 0) {
			for (int i = 0; i < this.usersInfo.size(); i++) {
				if(this.usersInfo.get(i).get(0).equals(id) && this.usersInfo.get(i).get(1).equals(pw) ) {
					System.out.printf("%s 님 로그인 완료",this.usersInfo.get(i).get(2));
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}

	public boolean checkDuplication() {
		if (this.usersInfo.size() > 0) {
			for (int i = 0; i < this.usersInfo.size(); i++) {
				if (this.inrollFrame.nameField.getText().equals(this.usersInfo.get(i).get(0))) {
					return false;
				}
			}
		}
		return true;
	}
}

public class Manager extends JFrame{
	public Manager() {
		setLayout(null);
		setBounds(100,100,410,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MainPanel());
		
		setVisible(true);
		revalidate();
		
	}
	public static void main(String[] args) {
		
		new Manager();
	}

}
