package gui_Login_Inrollment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class JoinFrame extends JFrame{
	
	JLabel idLabel = new JLabel("id : ");
	JLabel pwLabel = new JLabel("pw : ");
	JLabel nameLabel = new JLabel("name : ");
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField();
	
	public JoinFrame() {
		setLayout(null);
		setBounds(200,200,300,400);
		
		setTextField();

		setVisible(true);
		revalidate();
	}

	private void setTextField() {
		
		this.idLabel.setBounds(30,50,60,50);
		add(this.idLabel);
		
		this.idField.setBounds(90,50 ,150 ,50 );
		add(this.idField);
		
		this.pwLabel.setBounds(30,110,60,50);
		add(this.pwLabel);
		
		this.pwField.setBounds(90,110 ,150 ,50 );
		add(this.pwField);
		
		this.nameLabel.setBounds(30,170,60,50);
		add(this.nameLabel);
		
		this.nameField.setBounds(90,170 ,150 ,50 );
		add(this.nameField);
	}
}

class Ans_Panel extends JPanel implements KeyListener,ActionListener{
	
	
	private JButton login = new JButton();
	private JButton inrollment = new JButton();
	
	private Vector<Vector<String>> usersInfo = new Vector<>();
	private Vector<String> colName = null;
	
	private Inrollment inrollFrame ;
	private Login loginFrame;
	
	private JoinFrame joinFrame = null;
	
	JTable table = null;
	
	
	public Ans_Panel() {
		setLayout(null);
		setBounds(0, 0, 400, 600);
		
		setTable();
		
		setButton();
		
		//init();
	}
	
	private void init() {
		Random  rn = new Random();
		
		String[] front = {"김","이","박","정","오"};
		String[] back1 = {"성","지","우","아","희"};
		String[] back2 = {"연","무","안","용","이"};
		
		for(int i=0; i<100; i++) {
			Vector<String> user = new Vector<String>();
			String name = front[rn.nextInt(front.length)] + back1[rn.nextInt(back1.length)] + back2[rn.nextInt(back2.length)];
			user.add(name);
			user.add(i+"");
			user.add(i+"");
			this.usersInfo.add(colName);
		}
		
	}

	private void setTable() {
		this.colName = new Vector<String>();
		this.colName.add("id");
		this.colName.add("pw");
		this.colName.add("name");
		
		table = new JTable(usersInfo, colName);
		table.setBounds(50, 50, 300, 300);
		
		table.setBorder(new LineBorder(Color.red));
		table.setGridColor(Color.black);
		
		//add(table);
		
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 300, 300);
		js.setAutoscrolls(true); //default 
		add(js);
	}

	public Vector<Vector<String>> getUsersInfo (){
		return this.usersInfo;
	}

	private void setButton() {
		
		this.login.setBounds(100, 380, 100, 50);
		this.login.setText("Login");
		this.login.setVisible(true);
		this.login.addActionListener(this);
		add(this.login);
		
		this.inrollment.setBounds(210,380,100,50);
		this.inrollment.setText("Inrollment");
		this.inrollment.setVisible(true);
		this.inrollment.addActionListener(this);
		add(this.inrollment);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.inrollment) {
			this.joinFrame = new JoinFrame();
			
			this.joinFrame.idField.setFocusable(true);
			this.joinFrame.idField.addKeyListener(this);
			this.joinFrame.pwField.setFocusable(true);
			this.joinFrame.pwField.addKeyListener(this);
			this.joinFrame.nameField.setFocusable(true); 
			this.joinFrame.nameField.addKeyListener(this);
		}
		else if(e.getSource() ==  this.login){
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		Object target = e.getKeyCode();
		
		if(e.getKeyCode() == e.VK_ENTER || target == this.joinFrame.idField || target == this.joinFrame.pwField || target == this.joinFrame.nameField) {
			
			String id = this.joinFrame.idField.getText();
			String pw = this.joinFrame.pwField.getText();
			String name = this.joinFrame.nameField.getText();
			
			if(!id.equals("") && !pw.equals("") && !name.equals("")) {
				//join
				joinUser(id, pw,name);
			}
		}
		
	}

	private void joinUser(String id, String pw, String name) {
		boolean check = checkUserId(id);
		
		if(!check) {
			// User
			Vector<String> user = new Vector<>();
			user.add(id);
			user.add(pw);
			user.add(name);

			this.usersInfo.add(user);

			System.out.println("회원가입 완료");
			System.out.println("user.size() :" + this.usersInfo.size());
			
			table.revalidate();
			table.repaint();
			
			this.joinFrame.dispose(); //프레임에 대한 창 닫기 처리
		}
		else {
			// 단순 팝업창을 띄울때에만 사용 (권장 X)
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다");
			this.joinFrame.dispose();
		}
		
	}

	private boolean checkUserId(String id) {
		for(int i=0; i<this.usersInfo.size(); i++) {
			if(this.usersInfo.get(i).get(0).equals(id))
				return true;
		}
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class Ans_Login_Join extends JFrame{
	public Ans_Login_Join() {
		setLayout(null);
		setTitle("L&J");
		setBounds(100,100,400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Ans_Panel());
		
		setVisible(true);
		revalidate();
	}
	public static void main(String[] args) {
		new Ans_Login_Join(); 
	}

}
